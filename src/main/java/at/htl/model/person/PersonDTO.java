package at.htl.model.person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PersonDTO {
    private String SSN;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private boolean awesome;
    private float awesomeness;
    private BigDecimal wealth;

    public PersonDTO() {
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
        return awesome;
    }

    public void setAwesome(boolean awesome) {
        this.awesome = awesome;
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