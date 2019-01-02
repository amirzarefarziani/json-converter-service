package amir.json.converter.service;

import amir.json.converter.dto.*;
import amir.json.converter.service.mapper.ConverterObjectMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Singleton
public class ObjectConstructorService {

    private final ConverterObjectMapper mapper;

    @Inject
    public ObjectConstructorService(ConverterObjectMapper mapper){
        this.mapper = mapper;
    }

    public String convertByObjectConstructor(String personListAsJson) {
        EmployeeList employeeList = from(personListAsJson);
        return mapper.writeValue(employeeList);
    }
    private EmployeeList from(String personListAsJson) {
        PersonList personList = mapper.readValue(personListAsJson);
        return buildEmployeeListObject(personList);
    }
    private EmployeeList buildEmployeeListObject(PersonList personList) {
        return new EmployeeList
                .EmployeeListBuilder(buildEmployeeList(personList.getPersons()))
                .employeeListId(UUID.randomUUID().toString())
                .build();
    }

    private List<Employee> buildEmployeeList(List<Person> personList) {
        List<Employee> employeeList = new ArrayList<>();
        if(personList != null) {
            for (Person person : personList) {
                employeeList.add(buildEmployee(person));
            }
        }
        return employeeList;
    }

    private Employee buildEmployee(Person person) {
        return new Employee.EmployeeBuilder(new EmployeeName
                        .EmployeeNameBuilder(person.getFirstName(),person.getLastName())
                        .build())
                .departmentId(Integer.MAX_VALUE)
                .homeAddress(person.getAddress())
                .build();
    }
}
