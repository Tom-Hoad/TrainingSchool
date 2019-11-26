import java.lang.reflect.Array;
import java.util.ArrayList;

// The School class.
public class School {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;

    // The constructor for School. Takes the name.
    public School(String name) {
        this.name = name;
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        courses = new ArrayList<>();
        instructors = new ArrayList<>();
    }

    // Simulates a day at school.
    public void aDayAtSchool() {
        // Creates courses for all subjects that aren't taught.
        for (Subject subject : freeSubjects()) {
            Course course = new Course(subject, 2);
            add(course);
        }

        // Assigns an instructor to every course.
        for (Course course : getCourses()) {
            for (Instructor instructor : getInstructors()) {
                if (instructor.canTeach(course.getSubject()) && instructor.getAssignedCourse() == null && !course.hasInstructor()) {
                    course.setInstructor(instructor);
                    instructor.assignCourse(course);
                }
            }
        }

        // Enrolls all the free students on a course.
        for (Student student : getStudents()) {
            for (Course course : getCourses()) {
                if (!student.hasCertificate(course.getSubject()) && student.getEnrolledCourse() == null) {
                    course.enrolStudent(student);
                }
            }
        }

        // Moves the day on for all courses and removes finished courses.
        ArrayList<Course> toRemove = new ArrayList<>();

        for (Course course : getCourses()) {
            course.aDayPasses();

            // Removes any courses that are cancelled or finished.
            if (course.isCancelled() || course.getStatus() == 0) {
                toRemove.add(course);
            }
        }

        courses.removeAll(toRemove);
    }

    // Gets the subjects that aren't being taught.
    public ArrayList<Subject> freeSubjects() {
        ArrayList<Subject> freeSubjects = new ArrayList<>();
        freeSubjects.addAll(getSubjects());
        for (Course course : getCourses()) {
            freeSubjects.remove(course.getSubject());
        }
        return freeSubjects;
    }

    // Adds a student to the school.
    public void add(Student student) {
        students.add(student);
    }

    // Removes a student from the school.
    public void remove(Student student) {
        students.remove(student);
    }

    // Gets the ArrayList of students in the school.
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Adds a subject to the school.
    public void add(Subject subject) {
        subjects.add(subject);
    }

    // Removes a subject from the school.
    public void remove(Subject subject) {
        subjects.remove(subject);
    }

    // Gets the ArrayList of subjects in the school.
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    // Adds a course to the school.
    public void add(Course course) {
        courses.add(course);
    }

    // Removes a course from the school.
    public void remove(Course course) {
        courses.remove(course);
    }

    // Gets the ArrayList of courses in the school.
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Adds a instructor to the school.
    public void add(Instructor instructor) {
        instructors.add(instructor);
    }

    // Removes a instructor from the school.
    public void remove(Instructor instructor) {
        instructors.remove(instructor);
    }

    // Gets the ArrayList of instructors in the school.
    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    @Override
    public String toString() {
        return this.name + " has " + getSubjects().size() + " subjects, " + getCourses().size() + " courses, " +
                getInstructors().size() + " instructors and " + getStudents().size() + " students.";
    }
}
