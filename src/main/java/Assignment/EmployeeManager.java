/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.ArrayList;
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

}
