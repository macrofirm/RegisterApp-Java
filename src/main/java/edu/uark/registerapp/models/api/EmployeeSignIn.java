package edu.uark.registerapp.models.api;

public class EmployeeSignIn {

    private String employeeID;
    public String getEmployeeId() {
        return employeeID;
    }
    public EmployeeSignIn setEmployeeId(String employeeID) {
        this.employeeID = employeeID;
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