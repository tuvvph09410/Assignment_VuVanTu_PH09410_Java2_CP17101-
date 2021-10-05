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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

}
