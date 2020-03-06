


public void EmployeeCreateCommand{

    String employeeFirstName = this.employee.get

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
        if(password == null || password.lenth == 0){
            throw new UnprocessableEntityException("Password");
        }
        
    }

    //properties
    private Employee employee;
    public EmployeeCreateCommand setEmployee(Employee employee){
        this.employee = employee;
        return this;
    }


    private boolean isInitialEmployee;
}