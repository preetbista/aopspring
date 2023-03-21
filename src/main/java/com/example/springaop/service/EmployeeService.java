package com.example.springaop.service;

import com.example.springaop.model.Employee;
import com.example.springaop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee findById( Integer id ){
        return employeeRepository.findById(id).orElseThrow(null);
    }
}
