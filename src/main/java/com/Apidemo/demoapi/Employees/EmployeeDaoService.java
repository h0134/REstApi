package com.Apidemo.demoapi.Employees;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class EmployeeDaoService {
    private static List<Employee> employees=new ArrayList<>();
    private static int employeeCount=0;
    static
    {
        employees.add(new Employee(++employeeCount,"Yasu",23));
        employees.add(new Employee(++employeeCount,"Vrinda",25));
        employees.add(new Employee(++employeeCount,"Kenny",30));
    }
    public List<Employee> findAll()
    {
        return  employees;
    }
    public Employee save(Employee employee)
    {
        //employee.setId(++employeeCount);
        employees.add(employee);
        return employee;

    }
    public Employee findOne(int id) {
        Predicate<? super Employee> predicate = employee -> employee.getId()==id;
        return employees.stream().filter(predicate).findFirst().orElse(null);
    }
    public static Employee getEmployeeById(Integer id) {
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getId(), id))
                .findFirst()
                .orElse(null);
    }
    public void deleteById(Integer id) {
        Predicate<? super Employee> predicate = employee -> employee.getId()==id;
        employees.removeIf(predicate);
    }

    public static Employee updateEmployee(Integer id,
                                          Employee requestEmployee) {

        Employee employee = getEmployeeById(id);
        employee.setAge(requestEmployee.getAge());
        employee.setName(requestEmployee.getName());
        return employee;
    }
}