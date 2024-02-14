package dev.antoalex.empregbackend.controller;

import dev.antoalex.empregbackend.dto.EmployeeDto;
import dev.antoalex.empregbackend.model.Employee;
import dev.antoalex.empregbackend.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(
                employeeService.getEmployees(), HttpStatus.OK
        );
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Integer empId){
        return new ResponseEntity<Optional<Employee>>(
                employeeService.getEmployee(empId), HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<Employee>(
                employeeService.createEmployee(employeeDto), HttpStatus.OK
        );
    }
}
