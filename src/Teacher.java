// The Teacher class. Subclass to Instructor class.
public class Teacher extends Instructor {
    // The inherited constructor for Teacher from Person.
    public Teacher(String name, char gender, int age) {
        super(name, gender, age);
    }

    // Overrides the method from Instructor.
    public boolean canTeach(Subject subject) {
        return subject.getSpecialism() == 1 || subject.getSpecialism() == 2;
    }
}
