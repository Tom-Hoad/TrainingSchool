// The GUITrainer class. Subclass to Teacher class.
public class GUITrainer extends Teacher {
    // The inherited constructor for GUITrainer from Person.
    public GUITrainer(String name, char gender, int age) {
        super(name, gender, age);
    }

    // Overrides the method from Instructor.
    public boolean canTeach(Subject subject) {
        if (subject.getSpecialism() == 4) {
            return true;
        } else {
            return super.canTeach(subject);
        }
    }
}