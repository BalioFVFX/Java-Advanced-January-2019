import java.util.ArrayList;
import java.util.List;

public class Person {
    public String firstName;
    public String lastName;
    public String birthDate;
    public List<Person> parents;
    public List<Person> children;


    public Person() {
        this.firstName = null;
        this.lastName = null;
        this.birthDate = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String firstName, String lastName, String birthDate) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getFullName(), this.birthDate);
    }
}
