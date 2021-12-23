package at.htl.workloads.person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Person getPersonById(String ssn) {
        var query = entityManager.createQuery("select p from Person p where p.SSN = :ssn", Person.class);
        query.setParameter("ssn", ssn);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> getAllPeople() {
        var query = entityManager.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

    @Override
    public void addAddress(Address address) {
        entityManager.persist(address);
    }

    @Override
    public Long getAwesomePeopleCount() {
        var query = entityManager.createQuery("select count(p) from Person p where p.isAwesome = true", Long.class);
        return query.getResultStream().findFirst().orElse(0L);
    }

    @Override
    public List<String> getAllCities() {
        var query = entityManager.createQuery("select distinct a.town from Address a", String.class);
        return query.getResultList();
    }
}