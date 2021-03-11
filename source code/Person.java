package sample;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {
    private String name;             //Represents the name of the person
    private LocalDate dateOfBirth;   //Represents the date of birth of the person
    private final char gender;       //Represents the gender of the person
    private final int age;           //Represents the age of the person

    /**
     * Default constructor - invokes the parametric constructor
     */
    public Person() {
        this("Ghana", LocalDate.of(1957, 3, 6), 'F');
    }

    /**
     * @param name represents the name of the person as a string; "Elijah Boateng".
     * @param dob represents a person's date of birth which is more efficient than age for updating purposes
     * @param gender represents the gender of the person as a character; 'M' for males and 'F' for females
     */
    public Person(String name, LocalDate dob, char gender) {
        this.name = name;
        this.dateOfBirth = dob;
        this.gender = gender;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    //Accessor methods
    /**
     * @return the name of the person as a string
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age of the person as an integer
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the date of birth of the voter
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return the gender of the person as a string
     */
    public String getGender() {
        if (gender == 'M') {
            return "Male";
        } else {
            return "Female";
        }
    }

    //Mutator methods
    /**
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param dateOfBirth the date to be set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * toString method overridden from the Object class
     * @return the person's name and age by a title implying their gender
     */
    @Override
    public String toString() {
        if (gender == 'M') {
            return "Mr." + name +
                    "\nAge: " + age + " years";
        } else {
            return "Mrs." + name +
                    "\nAge: " + age + " years";
        }
    }

    /**
     * Called to indicate whether some other object is "equal to" this one.
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender == person.gender
                && age == person.age
                && Objects.equals(name, person.name)
                && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    /**
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, gender, age);
    }
}

