package amir.json.converter.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Employee {

    @JsonProperty("EmployeeName")
    private final EmployeeName employeeName;

    @JsonProperty("Age")
    private final String age;

    @JsonProperty("HomeAddress")
    private final String homeAddress;

    @JsonProperty("DepartmentId")
    private final Integer departmentId;

    private Employee(EmployeeBuilder builder) {
        this.employeeName = builder.employeeName;
        this.age = builder.age;
        this.homeAddress = builder.homeAddress;
        this.departmentId = builder.departmentId;
    }

    public String getAge() {
        return age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public EmployeeName getEmployeeName() {
        return employeeName;
    }

    public static class EmployeeBuilder {

        private EmployeeName employeeName;
        private String age;
        private String homeAddress;
        private Integer departmentId;

        public EmployeeBuilder(EmployeeName employeeName) {
            this.employeeName = employeeName;
        }

        public EmployeeBuilder age(String age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder homeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }

        public  EmployeeBuilder departmentId(Integer departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
