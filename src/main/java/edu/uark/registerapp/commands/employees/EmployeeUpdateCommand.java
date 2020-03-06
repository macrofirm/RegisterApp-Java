package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.repositories.EmployeeRepository;


@Service
public class EmployeeUpdateCommand implements ResultCommandInterface<Employee> {
	@Transactional
	@Override
    public Employee execute() {
        this.validateProperties();

        final Optional<EmployeeEntity> employeeEntity =
            this.employeeRepository.findById(this.id);
        if(!employeeEntity.isPresent()){
            throw new NotFoundException("Employee");

            this.apiEmployee = employeeEntity.get().synchronize(this.apiEmployee);

            this.employeeRepository.save(employeeEntity.get());
            
            return this.apiEmployee;
        }
    }

	// Helper methods
	private void validateProperties(){
        if(StringUtils.isBlank(this.apiEmployee.getFirstName())){
            throw new UnprocessableEntityException("firstName");
        }
        else if(StringUtils.isBlank(this.apiEmployee.getLastName())){
            throw new UnprocessableEntityException("lastName");
        }
    }

    // Properties
    private UUID recordId;
    private Employee apiEmployee;
    public UUID getRecordId(){
        return this.Id;
    }
	
	@Autowired
	private EmployeeRepository employeeRepository;
}
