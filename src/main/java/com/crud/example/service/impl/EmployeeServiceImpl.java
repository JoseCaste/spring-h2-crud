package com.crud.example.service.impl;

import com.crud.example.model.Employee;
import com.crud.example.repository.EmployeeRepository;
import com.crud.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Value("${devOps.path}")
    private String devOpsPath;

    @PostConstruct
    private void getValueFromProperties(){
        System.out.println(devOpsPath);
    }
    @Override
    public Employee getAndEmployee() throws Exception {
        return employeeRepository.findById(1L).orElseThrow(Exception::new);
    }
}
