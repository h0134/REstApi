package com.Apidemo.demoapi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
class EmployeeController {

    @Autowired  // default setter injection
    private EmployeeService employeeService;


    @GetMapping("/employee") // to get list of all employees
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getbyId(@PathVariable int id) {
        return employeeService.getempbyId(id);

    }


    @PostMapping("/employeeput")
    public void saveEmployee(@Valid @RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable int id) {
        boolean condition = employeeService.saveWhileUpdate(employee, id);
        return condition == true ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }



}