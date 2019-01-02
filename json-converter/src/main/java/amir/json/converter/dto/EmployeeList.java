package amir.json.converter.dto;

import com.google.common.collect.Lists;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class EmployeeList {

    @JsonProperty("EmployeeListId")
    private final String employeeListId;

    @JsonProperty("Employees")
    private final List<Employee> employeeList;

    private EmployeeList(EmployeeListBuilder builder) {
        this.employeeListId = builder.employeeListId;
        this.employeeList = builder.employeeList == null ? null : Lists.newArrayList(builder.employeeList);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String getEmployeeListId() {
        return employeeListId;
    }

    public static class EmployeeListBuilder {
        private String employeeListId;
        private List<Employee> employeeList;

        public EmployeeListBuilder(List<Employee> employeeList) {
            this.employeeList = employeeList== null ? new ArrayList() : employeeList;
        }

        public EmployeeListBuilder employeeListId(String employeeListId) {
            this.employeeListId = employeeListId;
            return this;
        }

        public EmployeeList build() {
            return new EmployeeList(this);
        }
    }
}
