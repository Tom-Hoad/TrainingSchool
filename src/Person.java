// The Person class.
public class Person {
    private String name;
    private char gender;
    private int age;

    // The constructor for a person. Takes the name, gender and age.
    public Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // Gets the persons name.
    public String getName() {
        return name;
    }

    // Gets the persons gender.
    public char getGender() {
        return gender;
    }

    // Sets the persons age.
    public void setAge(int age) {
        this.age = age;
    }

    // Gets the persons age.
    public int getAge() {
        return age;
    }
}
