package at.htl.workloads.person;

import at.htl.model.person.AddressDTO;
import at.htl.model.person.PersonDTO;

import java.util.List;

public interface PersonService { 
    boolean addPerson(PersonDTO newPerson);
    List<Person> getAllPeople();

    boolean addAddress(AddressDTO newAddress, String ssn);
    Long getAwesomePeopleCount();
    List<String> getAllCityNames();
}