package com.Apidemo.demoapi.Employees;

//import Employeecontrolller.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDaoService service;

    //GET REQUEST {for  particular employee}

    @GetMapping("/employees/{id}")
    public Employee retrieveUser(@PathVariable int id) throws EmployeeNotFoundException {
        Employee employee=service.findOne(id);
        if(employee==null)
            throw new EmployeeNotFoundException("No employee found with id:"+id);
        return employee;
    }
    //GET REQUEST
    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees()
    {
        return service.findAll();
    }
    //PUT MAPPING
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @RequestBody Employee employee){
        return EmployeeDaoService.updateEmployee(id, employee);
    }


    //DELETE
    @DeleteMapping("/employees/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

    //POST REQUEST
    @PostMapping("/employees")
    public void createEmployee(@Valid @RequestBody Employee employee)
    {
        service.save(employee);
    }

}