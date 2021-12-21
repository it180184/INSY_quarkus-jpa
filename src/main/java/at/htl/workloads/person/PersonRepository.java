package at.htl.workloads.person;

import java.util.List;

public interface PersonRepository {
    Person getPersonById(String ssn);
    void addPerson(Person person);
    List<Person> getAllPeople();
}