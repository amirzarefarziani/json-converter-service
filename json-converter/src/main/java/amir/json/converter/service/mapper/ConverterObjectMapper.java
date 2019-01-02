package amir.json.converter.service.mapper;

import amir.json.converter.dto.EmployeeList;
import amir.json.converter.dto.PersonList;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class ConverterObjectMapper {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterObjectMapper.class);

    public PersonList readValue(String personListAsJson){
        try {
            return mapper.readValue(personListAsJson, PersonList.class);
        } catch (IOException e) {
            LOGGER.error("readValue: exception caught: "+e);
            throw new RuntimeException(e);
        }
    }
    public String writeValue(EmployeeList employeeList) {
        try {
            mapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            return mapper.writeValueAsString(employeeList);
        } catch (IOException e) {
            LOGGER.error("writeValue: exception caught: "+e);
            throw new RuntimeException(e);
        }
    }
}
