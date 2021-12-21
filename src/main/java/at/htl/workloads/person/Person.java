package at.htl.workloads.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Person {

    @Id
    private String SSN;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private Boolean isAwesome;
    private Float awesomeness;
    private BigDecimal wealth;

    // getter and setter

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getAwesome() {
        return isAwesome;
    }

    public void setAwesome(Boolean awesome) {
        isAwesome = awesome;
    }

    public Float getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(Float awesomeness) {
        this.awesomeness = awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }
}