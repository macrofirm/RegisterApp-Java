package edu.uark.registerapp.commands.employees;




public class EmployeeUpdateCommand{
	
	public void execute(){

        
    }
	
    
    //Properties
    private int recordId;
    public EmployeeUpdateCommand EmployeeUpdateCommand(int recordId) {
        this.recordId = recordId;
        return this;
    }
	
	
}