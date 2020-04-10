package edu.uark.registerapp.models.api;

public class EmployeeSignIn {

    private String employeeId;
    public String getEmployeeId() {
        return employeeId;
    }
    public EmployeeSignIn setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    private String password;
    public String getPassword() {
        return password;
    }
    public EmployeeSignIn setPassword(String password) {
        this.password = password;
        return this;
    }
    
}