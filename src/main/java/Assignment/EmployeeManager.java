/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author vuvantu
 */
public class EmployeeManager implements EmployeeManager_Interface {

    private List<Employee> listEmployee;

    public EmployeeManager(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public EmployeeManager() {
        this.listEmployee = new ArrayList<>();
    }

    @Override
    public void add(Employee employee) {
        this.listEmployee.add(employee);
    }

    @Override
    public void update(int position, Employee employee) {
        this.listEmployee.set(position, employee);
    }

    @Override
    public void delete(int position) {
        this.listEmployee.remove(position);
    }

    @Override
    public void setList(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    @Override
    public Employee get(int position) {
        return this.listEmployee.get(position);
    }

    @Override
    public List<Employee> getList() {
        return this.listEmployee;
    }

    @Override
    public void writeFile(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream objectOS = new ObjectOutputStream(fos);

            objectOS.writeObject(getList());

            objectOS.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void readFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ObjectIS = new ObjectInputStream(fis);

            this.listEmployee = (List<Employee>) ObjectIS.readObject();

            ObjectIS.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public boolean checkID(String id) {
        try {
            for (int i = 0; i < getList().size(); i++) {
                Employee employee = getList().get(i);
                if (employee.getId().equals(id)) {
                    return true;
                }
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void arrangeName() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }

        };
        Collections.sort(getList(), comparator);
    }

    @Override
    public void arrangeID() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        Collections.sort(getList(), comparator);
    }

    @Override
    public void arrangeSalary() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                Double d1 = o1.getSalary();
                Double d2 = o2.getSalary();
                return d1.compareTo(d2);
            }
        };
        Collections.sort(getList(), comparator);
    }
}
