package com.hotelManagement.service;

import com.hotelManagement.model.Employees;
import com.hotelManagement.model.Hotel;
import com.hotelManagement.repo.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;

    public String updateEmployees(Employees employees) {
        employeesRepository.save(employees);
        return "Employee Updated";
    }

    public String createEmployees(Employees employee) {
            employeesRepository.save(employee);
            return "Employee " + employee.getName() + " added into the repository";
        }

    public String deleteEmployees(Long employeeId) {
        Optional<Employees> optionalEmployees = employeesRepository.findById(employeeId);
        if(optionalEmployees.isPresent()){
            employeesRepository.deleteById(employeeId);
            return "Employee Removed";
        }
        else{
            return "No Employee Present";
        }
    }

    public Object getEmployeeIdById(Long employeeId) {
        Optional<Employees> optionalEmployees = employeesRepository.findById(employeeId);
        if(optionalEmployees.isPresent()){
            return optionalEmployees;
        }
        else{
            return "No record found";
        }
    }

    public List<Employees> getEmployees() {
        return employeesRepository.findAll();
    }
}
