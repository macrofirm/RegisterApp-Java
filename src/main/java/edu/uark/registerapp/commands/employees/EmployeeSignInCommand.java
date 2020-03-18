package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.UnauthorizedException;
import edu.uark.registerapp.models.api.EmployeeSignIn;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

@Service
public class EmployeeSignInCommand implements ResultCommandInterface<EmployeeSignIn>{
    @Override
    public EmployeeSignIn execute() {
        String employeeId = this.apiEmployeeSignIn.getEmployeeId();
        String password = this.apiEmployeeSignIn.getPassword();
        System.out.println(employeeId);
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
            throw new UnauthorizedException();
        }
    }

    private void validatePassword(String password) {
        if (StringUtils.isBlank(password)) {
            throw new UnauthorizedException();
        }
    }

    private void verifyEmployeeExists(Optional<EmployeeEntity> employee) {
        if (!(employee.isPresent())) {
            throw new UnauthorizedException();
        }
    }

    private void verifyCorrectPassword(
        Optional<EmployeeEntity> employee, byte[] password) {
        if (!(Arrays.equals(employee.get().getPassword(), password)))
        {
            throw new UnauthorizedException();
        }
    }

    @Transactional
    private ActiveUserEntity createActiveUserEntity(
        Optional<EmployeeEntity> employee, String employeeId) {
        final Optional<ActiveUserEntity> queriedActiveUserEntity = 
            this.activeUserRepository
                .findByEmployeeId(employee.get().getId());
        if (queriedActiveUserEntity.isPresent()) {
            queriedActiveUserEntity.get().setSessionKey(this.sessionKey);
            activeUserRepository.save(queriedActiveUserEntity.get());
            return queriedActiveUserEntity.get();
        } else {
            ActiveUserEntity newActiveUserEntity = new ActiveUserEntity();
            newActiveUserEntity.setSessionKey(this.sessionKey);
            newActiveUserEntity.setEmployeeId(employee.get().getId());
            newActiveUserEntity.setClassification(employee.get().getClassification());
            newActiveUserEntity.setName(
                employee.get().getFirstName().concat(" ").concat(employee.get().getLastName()));
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
    public EmployeeSignInCommand setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ActiveUserRepository activeUserRepository;
}