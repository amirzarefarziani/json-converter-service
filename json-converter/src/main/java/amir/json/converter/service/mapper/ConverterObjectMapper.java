package amir.json.converter.service.mapper;

import amir.json.converter.dto.EmployeeList;
import amir.json.converter.dto.PersonList;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Date;

@Singleton
public class ConverterObjectMapper {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterObjectMapper.class);

    public PersonList readValue(String personListAsJson){
        try {
            LOGGER.info("readValue() from personListAsJson to PersonList - started at: "+ new Date().toString());
            PersonList personList = mapper.readValue(personListAsJson, PersonList.class);
            LOGGER.info("readValue() from personListAsJson to PersonList - ended at: "+ new Date().toString());
            return personList;
        } catch (IOException e) {
            LOGGER.error("readValue: exception caught: "+e);
            throw new RuntimeException(e);
        }
    }
    public String writeValue(EmployeeList employeeList) {
        try {
            LOGGER.info("writeValue() from employeeList - started at: "+ new Date().toString());
            String json = mapper.writeValueAsString(employeeList);
            LOGGER.info("writeValue() from employeeList - started at: "+ new Date().toString());
            return json;
        } catch (IOException e) {
            LOGGER.error("writeValue: exception caught: "+e);
            throw new RuntimeException(e);
        }
    }
}
