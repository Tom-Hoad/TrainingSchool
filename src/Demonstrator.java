// The Demonstrator class. Subclass to Instructor class.
public class Demonstrator extends Instructor {
    // The inherited constructor for Demonstrator from Person.
    public Demonstrator(String name, char gender, int age) {
        super(name, gender, age);
    }

    // Overrides the method from Instructor.
    public boolean canTeach(Subject subject) {
        return subject.getSpecialism() == 2;
    }
}

