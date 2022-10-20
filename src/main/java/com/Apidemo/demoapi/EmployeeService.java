package com.Apidemo.demoapi;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EmployeeService {
    private static List<Employee> li;

    public  static  int counter=105;

    static {
        li = new ArrayList<>();
        li.add(new Employee(101, "ria", 22));
        li.add(new Employee(102, "sia", 23));
        li.add(new Employee(103, "ka", 21));
        li.add(new Employee(104, "ki", 20));
        li.add(new Employee(105, "pia", 24));
    }


    public List<Employee> getEmployee() {
        return li;
    }

    public Employee getempbyId(int id){
      return    li.stream().filter(emp-> emp.id== id).findFirst().orElse(null);
    }



    //post method
    public Employee save(Employee employee) {

        employee.setId(++counter);
        li.add(employee);
        return (Employee) li;
    }
    public boolean deleteEmployee(int id) {
        Predicate<Employee> predicate = employee -> employee.getId()==id;
        return li.removeIf(predicate);
    }

    public boolean saveWhileUpdate(Employee employee, int id) {
        boolean condition = false;
        for (Employee employee1 : li) {
            if (employee1.getId()==(id)) {
                employee1.setId(employee.getId());
                employee1.setAge(employee.getAge());
                employee1.setName(employee.getName());
                condition = true;
            }

        }
        return condition;
    }
}

