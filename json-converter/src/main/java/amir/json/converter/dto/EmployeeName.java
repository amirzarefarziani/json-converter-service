package amir.json.converter.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class EmployeeName {

    @JsonProperty("FirstName")
    private final String employeeFirstName;

    @JsonProperty("LastName")
    private final String employeeLastName;

    private EmployeeName(EmployeeNameBuilder builder){
        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public static class EmployeeNameBuilder {

        private String employeeFirstName;
        private String employeeLastName;

        public EmployeeNameBuilder(String employeeFirstName, String employeeLastName) {
            this.employeeFirstName = employeeFirstName;
            this.employeeLastName = employeeLastName;
        }

        public EmployeeName build() {
            return new EmployeeName(this);
        }
    }

}