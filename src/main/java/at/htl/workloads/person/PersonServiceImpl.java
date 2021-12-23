package at.htl.workloads.person;

import at.htl.model.person.AddressDTO;
import at.htl.model.person.PersonDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean addPerson(PersonDTO newPerson) {
        var existingPerson = personRepository.getPersonById(newPerson.getSSN());
        if (existingPerson != null) {
            return false;
        }

        var person = new Person();
        person.setSSN(newPerson.getSSN());
        person.setDateOfBirth(newPerson.getDateOfBirth());
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setAwesome(newPerson.isAwesome());
        person.setAwesomeness(newPerson.getAwesomeness());
        person.setWealth(newPerson.getWealth());
        personRepository.addPerson(person);
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.getAllPeople();
    }

    @Override
    public boolean addAddress(AddressDTO newAddress, String ssn) {
        var person = personRepository.getPersonById(ssn);
        if (person == null) {
            return false;
        }

        var address = new Address();
        address.setCountry(newAddress.getCountry());
        address.setHouseNo(newAddress.getHouseNo());
        address.setStreet(newAddress.getStreet());
        address.setTown(newAddress.getTown());
        address.setZipCode(newAddress.getZipCode());
        address.setPerson(person);
        personRepository.addAddress(address);
        return true;
    }

    @Override
    public Long getAwesomePeopleCount() {
        return personRepository.getAwesomePeopleCount();
    }

    @Override
    public List<String> getAllCityNames() {
        return personRepository.getAllCities();
    }
}