package at.htl.workloads.person;

import at.htl.IntTestBase;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
public class PersonRepositoryTest extends IntTestBase {

    @Inject
    private PersonRepositoryImpl personRepository;

    @Test
    public void addPerson_getPerson_simple_success() {
        var personToAdd = new Person();
        personToAdd.setSSN("1234010100");
        personToAdd.setDateOfBirth(LocalDate.of(2000,1,1));
        personToAdd.setFirstName("Horst");
        personToAdd.setLastName("Fuchs");
        personToAdd.setAwesome(true);
        personToAdd.setAwesomeness(44.33f);
        personToAdd.setWealth(BigDecimal.valueOf(789.12));

        assertThatCode(()->personRepository.addPerson(personToAdd)).doesNotThrowAnyException();
        var loadedPerson = personRepository.getPersonById(personToAdd.getSSN());

        assertThat(loadedPerson).isNotNull().isEqualTo(personToAdd);
    }

    @Test
    public void getPerson_notExists(){
        var ssn = "1234010100";

        AtomicReference<Person> loadedPerson = new AtomicReference<>();
        assertThatCode(()->{
            loadedPerson.set(personRepository.getPersonById(ssn));
        }).doesNotThrowAnyException();

        assertThat(loadedPerson.get()).isNull();
    }

    @Test
    public void addAddress_simple_success() {
        var addressToAdd = new Address();
        addressToAdd.setStreet("Musterstraße");
        addressToAdd.setHouseNo("2");
        addressToAdd.setZipCode("1234");
        addressToAdd.setTown("Musterdorf");
        addressToAdd.setCountry("Österreich");
        addressToAdd.setPerson(null);

        assertThatCode(()->personRepository.addAddress(addressToAdd)).doesNotThrowAnyException();
    }

    @Test
    public void getAwesomePeopleCountTest() {
        assertThat(personRepository.getAwesomePeopleCount()).isEqualTo(1L);
    }

    @Test
    public void getAllCitiesTest() {
        var cities = personRepository.getAllCities();
        assertThat(cities).isNotNull();
        assertThat(cities.size()).isEqualTo(1);
        assertThat(cities.get(0)).isEqualTo("Musterdorf");
    }

}