/**
 * Abstract base class representing a generic employee.
 */
abstract class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private Date birthDate;

    /**
     * Constructs an Employee with name, SSN, and birth date.
     */
    public Employee(String firstName, String lastName, String ssn, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = ssn;
        this.birthDate = birthDate;
    }

    /** @return first name */
    public String getFirstName() { return firstName; }

    /** @return last name */
    public String getLastName() { return lastName; }

    /** @return SSN */
    public String getSocialSecurityNumber() { return socialSecurityNumber; }

    /** @return birth date */
    public Date getBirthDate() { return birthDate; }

    /**
     * Returns a formatted string with employee details.
     */
    public String toString() {
        return String.format("%s %s\nSSN: %s\nBirth Date: %s",
                getFirstName(), getLastName(), getSocialSecurityNumber(), getBirthDate());
    }

    /**
     * Abstract method to compute earnings.
     */
    public abstract double earnings();
}