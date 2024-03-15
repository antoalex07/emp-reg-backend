package dev.antoalex.empregbackend.service.Implement;

import dev.antoalex.empregbackend.dto.EmployeeDto;
import dev.antoalex.empregbackend.model.Employee;
import dev.antoalex.empregbackend.repository.EmployeeRepository;
import dev.antoalex.empregbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee employee: employees){
            EmployeeDto employeeDto = mapToDto(employee);
            employeeDtos.add(employeeDto);
        }

        return employeeDtos;
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

    @Override
    public Boolean checkEmployeeExistence(Integer empId) {
        return employeeRepository.existsByEmpId(empId);
    }

    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();

        employee.setEmpId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setWageRate(employeeDto.getWageRate());
        employee.setOvertimeRate(employeeDto.getOvertimeRate());
        employee.setDueAmount(employeeDto.getDueAmount());

        return employee;
    }

    private EmployeeDto mapToDto(Employee employee) {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId(employee.getEmpId());
        employeeDto.setName(employee.getName());
        employeeDto.setWageRate(employee.getWageRate());
        employeeDto.setOvertimeRate(employee.getOvertimeRate());
        employeeDto.setDueAmount(employee.getDueAmount());

        return employeeDto;
    }
}










