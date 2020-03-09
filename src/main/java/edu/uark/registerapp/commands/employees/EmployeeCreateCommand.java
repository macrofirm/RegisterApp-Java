package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.Arrays;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

public class EmployeeCreateCommand{

    public EmployeeCreateCommand execute(){

    String employeeFirstName = Employee.getFirstName();
    String employeeLastName = Employee.getemployeeLastName();
    byte[] password = Employee.getPassword();
    this.validateEmployeeFirstName(employeeFirstName);
    this.validateEmployeeLastName(employeeLastName);
    this.validateEmployeePassword(password);

}
    //helper methodss
    private void validateEmployeeFirstName(String employeeFirstName) {
        if (StringUtils.isBlank(employeeFirstName)) {
            throw new UnprocessableEntityException("First Name");
        }
    }
    
    private void validateEmployeeLastName(String employeeLastName) {
        if (StringUtils.isBlank(employeeLastName)) {
            throw new UnprocessableEntityException("Last Name");
        }
    }

    private void validateEmployeePassword(byte[] password){
        if(password == null || password.length == 0){
            throw new UnprocessableEntityException("Password");
        }
        
    }

    //properties
    private EmployeeCreate employeeCreate;
    public EmployeeCreateCommand setEmployee(EmployeeCreate employeeCreate){
        this.employeeCreate = employeeCreate;
        return this;
    }


    private boolean isInitialEmployee;
}