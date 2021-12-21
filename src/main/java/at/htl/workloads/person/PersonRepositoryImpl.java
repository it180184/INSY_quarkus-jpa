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
}