package amir.json.converter.dto;

import java.util.List;

public class PersonList {

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "persons=" + persons +
                '}';
    }
}
