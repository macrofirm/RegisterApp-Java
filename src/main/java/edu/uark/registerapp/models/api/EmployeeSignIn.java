package edu.uark.registerapp.models.api;

public class EmployeeSignIn {

    private String employeeID;
    public String getEmployeeID() {
        return employeeID;
    }
    public EmployeeSignIn setEmployeeID(String employeeID) {
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