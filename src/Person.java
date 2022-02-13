/**
 * Person object representing a person
 */
public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s,%s", this.lastName, this.firstName);
    }

    public int compareTo(Object other) {
        // Check lastname
        String thisLastName = this.lastName.toUpperCase();
        String otherLastName = ((Person) other).lastName.toUpperCase();
        if (this.lastName.equals(otherLastName)) {
            // Check firstname
            String thisFirstName = this.firstName.toUpperCase();
            String otherFirstName = ((Person) other).firstName.toUpperCase();
            return thisFirstName.compareTo(otherFirstName);
        } else {
            return thisLastName.compareTo(otherLastName);
        }
    }
}
