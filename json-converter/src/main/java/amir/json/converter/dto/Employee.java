package amir.json.converter.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class Employee {

    @JsonProperty("EmployeeName")
    private EmployeeName employeeName;

    @JsonProperty("Age")
    private String age;

    @JsonProperty("HomeAddress")
    private String homeAddress;

    @JsonProperty("DepartmentId")
    private Integer departmentId;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    public EmployeeName getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(EmployeeName employeeName) {
        this.employeeName = employeeName;
    }

    public class EmployeeName {

        @JsonProperty("FirstName")
        private String employeeFirstName;

        @JsonProperty("LastName")
        private String employeeLastName;

        public String getEmployeeFirstName() {
            return employeeFirstName;
        }

        public void setEmployeeFirstName(String employeeFirstName) {
            this.employeeFirstName = employeeFirstName;
        }

        public String getEmployeeLastName() {
            return employeeLastName;
        }

        public void setEmployeeLastName(String employeeLastName) {
            this.employeeLastName = employeeLastName;
        }
    }

}
