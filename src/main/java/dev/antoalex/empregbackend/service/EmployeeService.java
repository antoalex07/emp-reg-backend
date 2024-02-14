package dev.antoalex.empregbackend.service;

import dev.antoalex.empregbackend.dto.EmployeeDto;
import dev.antoalex.empregbackend.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Optional<Employee> getEmployee(Integer empId);

    public Employee createEmployee(EmployeeDto employeeDto);
}
