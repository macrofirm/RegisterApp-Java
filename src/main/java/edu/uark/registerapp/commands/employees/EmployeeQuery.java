package edu.uark.registerapp.commands.employees;

import org.springframework.beans.factory.annotation.Autowired;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.repositories.EmployeeRepository;


public class EmployeeQuery implements VoidCommandInterface{
    
    @Override
    public void execute() {
        if (!(employeeRepository.findById(true))){
            throw new NotFoundException("Active User");
        }
    }

	//Properties
    private int employeeRecordId;
    public EmployeeQuery setRecordId(int employeeRecordId){
        this.employeeRecordId = employeeRecordId;
        return this;
    }	

    @Autowired
    private EmployeeRepository employeeRepository;
}