// The OOTrainer class. Subclass to Teacher class.
public class OOTrainer extends Teacher {
    // The inherited constructor for OOTrainer from Person.
    public OOTrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    // Overrides the method from Instructor.
    public boolean canTeach(Subject subject) {
        if (subject.getSpecialism() == 3) {
            return true;
        } else {
            return super.canTeach(subject);
        }
    }
}