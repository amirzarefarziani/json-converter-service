package amir.json.converter.service;

import amir.json.converter.dto.Person;
import amir.json.converter.dto.PersonList;
import amir.json.converter.service.mapper.ConverterObjectMapper;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Singleton
public class JsonGeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonGeneratorService.class);
    private final ConverterObjectMapper mapper;

    @Inject
    public JsonGeneratorService(ConverterObjectMapper mapper){
        this.mapper = mapper;
    }

    public ByteArrayOutputStream convertByJsonGenerator(String personListAsJson){
        PersonList personList = mapper.readValue(personListAsJson);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            final JsonGenerator jsonGenerator = new JsonFactory()
                    .createJsonGenerator(output, JsonEncoding.UTF8);

            jsonGenerator.writeStartObject();

                jsonGenerator.writeStringField("EmployeeListId",UUID.randomUUID().toString());

                jsonGenerator.writeArrayFieldStart("Employees");
                    for(Person person: personList.getPersons()) {
                        jsonGenerator.writeStartObject();

                            jsonGenerator.writeObjectFieldStart("EmployeeName");
                                jsonGenerator.writeStringField("EmployeeFirstName",person.getFirstName());
                                jsonGenerator.writeStringField("EmployeeLastName",person.getLastName());
                            jsonGenerator.writeEndObject();

                            jsonGenerator.writeStringField("Age",person.getAge());
                            jsonGenerator.writeStringField("HomeAddress",person.getAddress());
                            jsonGenerator.writeNumberField("DepartmentId",Integer.MAX_VALUE);

                        jsonGenerator.writeEndObject();
                    }
                jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();

            jsonGenerator.close();
            jsonGenerator.flush();
            return output;
        } catch (IOException e) {
            LOGGER.error("convert: exception caught: "+e);
            throw new RuntimeException(e);
        }
    }
}
