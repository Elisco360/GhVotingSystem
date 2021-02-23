package sample;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {
    //Instance variables - Person's attributes needed in context
    private String name;
    private LocalDate dateOfBirth;
    private char gender;
    private int age;

    //Constructors

    /**
     * Default constructor - invokes the parametric constructor
     */
    public Person() {
        this("Ghana", LocalDate.of(1957, 3, 6), 'F');
    }

    /**
     * Parametric constructor
     *
     * @param name   represents the name of the person as a string; "Elijah Boateng".
     * @param dob    represents a person's date of birth which is more efficient than age for updating purposes
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
     * A getter method for a person's name
     *
     * @return the name of the person as a string
     */
    public String getName() {
        return name;
    }

    /**
     * A getter method for a person's age
     * @return the age of the person as an integer
     */
    public int getAge() {
        return age;
    }

    protected LocalDate getDateOfBirth(){ return dateOfBirth; }

    /**
     * A getter method for  persons gender
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
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
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

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, gender, age);
    }
}

