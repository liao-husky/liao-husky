package model.Personnel;

import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
    private List<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public Person newPerson(String name) {
        Person person = new Person(name);
        personList.add(person);
        return person;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
