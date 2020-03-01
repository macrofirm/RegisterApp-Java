package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

public class EmployeeSignInCommand implements ResultCommandInterface<EmployeeSignIn>{
    @Override
    public EmployeeSignIn execute() {
        String employeeId = this.apiEmployeeSignIn.getEmployeeID();
        String password = this.apiEmployeeSignIn.getPassword();
        this.validateEmployeeId(employeeId);
        this.validatePassword(password);
        Optional<EmployeeEntity> employee = employeeRepository.findByEmployeeId(Integer.parseInt(employeeId));
        this.verifyEmployeeExists(employee);
        this.verifyCorrectPassword(employee, password.getBytes());

        return this.apiEmployeeSignIn;
    }

    // Helper methods
    private void validateEmployeeId(String employeeId) {
        try {
            Integer.parseInt(employeeId);
        } catch(NumberFormatException e) {
            throw new UnprocessableEntityException("EmployeeID");
        }
    }

    private void validatePassword(String password) {
        if (StringUtils.isBlank(password)) {
            throw new UnprocessableEntityException("Password");
        }
    }

    private void verifyEmployeeExists(Optional<EmployeeEntity> employee) {
        if (!(employee.isPresent())) {
            throw new UnprocessableEntityException("EmployeeID");
        }
    }

    private void verifyCorrectPassword(Optional<EmployeeEntity> employee, byte[] password) {
        if (Arrays.equals(employee.get().getPassword(), password))
        {
            throw new UnprocessableEntityException("Password");
        }
    }

    // Properties
    private EmployeeSignIn apiEmployeeSignIn;
    public EmployeeSignInCommand setApiEmployeeSignIn(final EmployeeSignIn apiEmployeeSignIn) {
        this.apiEmployeeSignIn = apiEmployeeSignIn;
        return this;
    }

    private String SessionKey;

    @Autowired
	private EmployeeRepository employeeRepository;
}