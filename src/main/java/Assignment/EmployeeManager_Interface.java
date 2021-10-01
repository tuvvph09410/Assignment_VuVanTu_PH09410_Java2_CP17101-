/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.List;

/**
 *
 * @author vuvantu
 */
public interface EmployeeManager_Interface {

    public void add(Employee employee);

    public void update(int position, Employee employee);

    public void delete(int position);

    public void setList(List<Employee> listEmployee);

    public Employee get(int position);

    public List<Employee> getList();
}
