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
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

@Service
public class EmployeeSignInCommand implements ResultCommandInterface<EmployeeSignIn>{
    @Override
    public EmployeeSignIn execute() {
        String employeeId = this.apiEmployeeSignIn.getEmployeeID();
        String password = this.apiEmployeeSignIn.getPassword();
        this.validateEmployeeId(employeeId);
        this.validatePassword(password);
        Optional<EmployeeEntity> employee = 
            employeeRepository.findByEmployeeId(Integer.parseInt(employeeId));
        this.verifyEmployeeExists(employee);
        this.verifyCorrectPassword(employee, password.getBytes());
        this.createActiveUserEntity(employee, employeeId);

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

    private void verifyCorrectPassword(
        Optional<EmployeeEntity> employee, byte[] password) {
        if (Arrays.equals(employee.get().getPassword(), password))
        {
            throw new UnprocessableEntityException("Password");
        }
    }

    @Transactional
    private ActiveUserEntity createActiveUserEntity(
        Optional<EmployeeEntity> employee, String employeeId) {
        final Optional<ActiveUserEntity> queriedActiveUserEntity = 
            this.activeUserRepository
                .findByEmployeeId(UUID.fromString(this.apiEmployeeSignIn.getEmployeeID()));
        if (queriedActiveUserEntity.isPresent()) {
            queriedActiveUserEntity.get().setSessionKey(this.sessionKey);
            activeUserRepository.save(queriedActiveUserEntity.get());
            return queriedActiveUserEntity.get();
        } else {
            ActiveUserEntity newActiveUserEntity = new ActiveUserEntity();
            newActiveUserEntity.setSessionKey(this.sessionKey);
            newActiveUserEntity.setEmployeeId(
                UUID.fromString(this.apiEmployeeSignIn.getEmployeeID()));
            newActiveUserEntity.setClassification(employee.get().getClassification());
            newActiveUserEntity.setName(
                employee.get().getFirstName() + " " + employee.get().getLastName());
            activeUserRepository.save(newActiveUserEntity);
            return newActiveUserEntity;
        }
    }

    // Properties
    private EmployeeSignIn apiEmployeeSignIn;
    public EmployeeSignInCommand setApiEmployeeSignIn(final EmployeeSignIn apiEmployeeSignIn) {
        this.apiEmployeeSignIn = apiEmployeeSignIn;
        return this;
    }

    private String sessionKey;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ActiveUserRepository activeUserRepository;
}