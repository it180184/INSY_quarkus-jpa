package at.htl.model.person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonDTO {
    private String SSN;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean isAwesome;
    private float awesomeness;
    private BigDecimal wealth;

    public PersonDTO() {
    }

    public PersonDTO(String ssn, LocalDate dateOfBirth, String firstName, String lastName, boolean isAwesome, float awesomeness, BigDecimal wealth) {
        SSN = ssn;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAwesome = isAwesome;
        this.awesomeness = awesomeness;
        this.wealth = wealth;
    }

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

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public float getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(float awesomeness) {
        this.awesomeness = awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }
}