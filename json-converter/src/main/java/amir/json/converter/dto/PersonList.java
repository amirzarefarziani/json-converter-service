package amir.json.converter.dto;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class PersonList {

    @JsonProperty("Persons")
    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
