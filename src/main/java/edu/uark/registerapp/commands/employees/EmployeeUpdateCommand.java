/*
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
            this.employeeRepository.findById(this.recordId);
        if(!employeeEntity.isPresent()){
            throw new NotFoundException("Employee");
        }
            this.apiEmployee = employeeEntity.get().synchronize(this.apiEmployee);

            this.employeeRepository.save(employeeEntity.get());
            
            return this.apiEmployee;
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
        return this.recordId;
    }
    public EmployeeUpdateCommand setEmployeeRecordId(final UUID employeeRecordId){
        this.recordId = employeeRecordId;
        return this;
    }
    public Employee getApiEmployee(){
        return this.apiEmployee;
    }
    public EmployeeUpdateCommand setApiEmployee(final Employee apiEmployee) {
        this.apiEmployee = apiEmployee;
        return this;
    }
	
	@Autowired
	private EmployeeRepository employeeRepository;
}
*/

package edu.uark.registerapp.commands.employees;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Employee;
import edu.uark.registerapp.models.entities.EmployeeEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;
import edu.uark.registerapp.models.repositories.EmployeeRepository;

@Service
public class EmployeeUpdateCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		this.validateProperties();
		
		this.updateEmployeeEntity();

		return this.apiEmployee;
	}

	// Helper methods
	private void validateProperties() {
		if (StringUtils.isBlank(this.apiEmployee.getFirstName())) {
			throw new UnprocessableEntityException("first name");
		}
		if (StringUtils.isBlank(this.apiEmployee.getLastName())) {
			throw new UnprocessableEntityException("last name");
		}
		if (EmployeeClassification.map(this.apiEmployee.getClassification()) == EmployeeClassification.NOT_DEFINED) {
			throw new UnprocessableEntityException("classification");
		}
	}

	@Transactional
	private void updateEmployeeEntity() {
		final Optional<EmployeeEntity> queriedEmployeeEntity =
			this.employeeRepository.findById(this.employeeId);

		if (!queriedEmployeeEntity.isPresent()) {
			throw new NotFoundException("Employee"); // No record with the associated record ID exists in the database.
		}

		this.apiEmployee = queriedEmployeeEntity.get()
			.synchronize(this.apiEmployee); // Synchronize any incoming changes for UPDATE to the database.

		this.employeeRepository.save(queriedEmployeeEntity.get()); // Write, via an UPDATE, any changes to the database.
	}

	// Properties
	private UUID employeeId;
	public UUID getEmployeeId() {
		return this.employeeId;
	}
	public EmployeeUpdateCommand setEmployeeId(final UUID employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeUpdateCommand setApiEmployee(final Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}

	@Autowired
	private EmployeeRepository employeeRepository;
}
