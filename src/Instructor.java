// The abstract Instructor class. Subclass to Person class.
public abstract class Instructor extends Person {
    private Course assignedCourse;

    // The inherited constructor for Instructor from Person.
    public Instructor(String name, char gender, int age) {
        super(name, gender, age);
    }

    // Assigns a course to an instructor.
    public void assignCourse(Course assignedCourse) {
        this.assignedCourse = assignedCourse;
    }

    // Unassigns a course from an instructor.
    public void unassignCourse() {
        assignedCourse = null;
    }

    // Gets the assigned course of an instructor.
    public Course getAssignedCourse() {
        return assignedCourse;
    }

    // The abstract method to say if they can teach.
    public abstract boolean canTeach(Subject subject);
}
