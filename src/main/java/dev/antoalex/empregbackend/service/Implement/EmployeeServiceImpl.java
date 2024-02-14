package dev.antoalex.empregbackend.service.Implement;

import dev.antoalex.empregbackend.dto.EmployeeDto;
import dev.antoalex.empregbackend.model.Employee;
import dev.antoalex.empregbackend.repository.EmployeeRepository;
import dev.antoalex.empregbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Integer empId) {
        return employeeRepository.findByEmpId(empId);
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEntity(employeeDto);
        return employeeRepository.save(employee);
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();

        employee.setEmpId(employeeDto.getEmpId());
        employee.setName(employeeDto.getName());
        employee.setWageRate(employeeDto.getWageRate());
        employee.setOvertimeRate(employeeDto.getOvertimeRate());
        employee.setDueAmount(employeeDto.getDueAmount());

        return employee;
    }
}










