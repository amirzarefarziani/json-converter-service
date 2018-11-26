package amir.json.converter.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class EmployeeList {

    @JsonProperty("EmployeeListId")
    private String employeeListId;

    @JsonProperty("Employees")
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getEmployeeListId() {
        return employeeListId;
    }

    public void setEmployeeListId(String employeeListId) {
        this.employeeListId = employeeListId;
    }

}
