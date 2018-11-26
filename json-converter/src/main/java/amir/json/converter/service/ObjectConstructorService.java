package amir.json.converter.service;

import amir.json.converter.dto.Employee;
import amir.json.converter.dto.EmployeeList;
import amir.json.converter.dto.Person;
import amir.json.converter.dto.PersonList;
import amir.json.converter.service.mapper.ConverterObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Singleton
public class ObjectConstructorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectConstructorService.class);

    private final ConverterObjectMapper mapper;

    @Inject
    public ObjectConstructorService(ConverterObjectMapper mapper){
        this.mapper = mapper;
    }

    public String convertByObjectConstructor(String personListAsJson) {
        LOGGER.info("convertByObjectConstructor() - started at: "+ new Date().toString());
        EmployeeList employeeList = convert(personListAsJson);
        return mapper.writeValue(employeeList);
    }
    private EmployeeList convert(String personListAsJson) {
        LOGGER.info("convert() from personListAsJson to EmployeeList - started at: "+ new Date().toString());
        PersonList personList = mapper.readValue(personListAsJson);
        return convert(personList);
    }
    private EmployeeList convert(PersonList personList) {
        LOGGER.info("convert() from PersonList to EmployeeList - started at: "+ new Date().toString());
        EmployeeList employeeList = new EmployeeList();
        employeeList.setEmployeeListId(UUID.randomUUID().toString());
        employeeList.setEmployeeList(convert(personList.getPersonList()));
        LOGGER.info("convert() from PersonList to EmployeeList - ended at: "+ new Date().toString());
        return employeeList;
    }
    private List<Employee> convert(List<Person> personList) {
        LOGGER.info("convert() from List<Person> to List<Employee> - started at: "+ new Date().toString());
        List<Employee> employeeList = new ArrayList<>();
        for(Person person: personList){
            employeeList.add(convert(person));
        }
        LOGGER.info("convert() from List<Person> to List<Employee> - ended at: "+ new Date().toString());
        return employeeList;
    }
    private Employee convert(Person person) {
        Employee employee = new Employee();
        employee.setEmployeeName(employee.new EmployeeName());
        employee.getEmployeeName().setEmployeeFirstName(person.getFirstName());
        employee.getEmployeeName().setEmployeeLastName(person.getLastName());
        employee.setAge(person.getAge());
        employee.setHomeAddress(person.getAddress());
        employee.setDepartmentId(Integer.MAX_VALUE);
        return employee;
    }

}
