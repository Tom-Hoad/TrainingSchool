import java.util.ArrayList;

// The Course class.
public class Course {
    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;
    private ArrayList<Student> enrolledStudents;
    private Instructor instructor;
    private boolean courseRunning;

    // The constructor for Course. Takes the subject and time till start. Initialises the enrolledStudents ArrayList.
    public Course(Subject subject, int daysUntilStarts) {
        this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        this.daysToRun = subject.getDuration();
        enrolledStudents = new ArrayList<>();
        courseRunning = true;
    }

    // Gets the subject.
    public Subject getSubject() {
        return subject;
    }

    // Gets the course status: positive = running, negative = waiting, 0 = done.
    public int getStatus() {
        if (daysUntilStarts > 0) {
            return 0 - daysUntilStarts;
        } else if (daysToRun > 0) {
            return daysToRun;
        } else {
            return 0;
        }
    }

    // Moves on a day.
    public void aDayPasses() {
        if (getStatus() < 0) {
            daysUntilStarts--;

            // Checks if the course can run on the day before it starts.
            if (daysUntilStarts == 0 ) {
                if (instructor == null || getSize() == 0) {
                    courseRunning = false;
                    endCourse();
                }
            }
        } else if (getStatus() > 0) {
            // Moves on if the course is running.
            if (!isCancelled()) {
                daysToRun--;

                // Graduates the students when the course is over.
                if (getStatus() == 0) {
                    for (Student student : enrolledStudents) {
                        student.graduate(this.subject);
                        student.setEnrolledCourse(null);
                    }
                }
            }
        }
    }

    // Enrols a student on the course.
    public boolean enrolStudent(Student student) {
        if (getSize() > 2 || getStatus() > -1) {
            return false;
        } else {
            enrolledStudents.add(student);
            student.setEnrolledCourse(this);
            return true;
        }
    }

    // Gets the number of students enrolled on the course.
    public int getSize() {
        return enrolledStudents.size();
    }

    // Gets the array of enrolled students.
    public Student[] getStudents() {
        return enrolledStudents.toArray(Student[]::new);
    }

    // Sets the assigned instructor.
    public boolean setInstructor(Instructor instructor) {
        if (instructor.canTeach(this.subject)) {
            this.instructor = instructor;
            return true;
        } else {
            return false;
        }
    }

    // Finds if an instructor is assigned to the course.
    public boolean hasInstructor() {
        return instructor != null;
    }

    // Gets if the course is cancelled.
    public boolean isCancelled() {
        return !courseRunning;
    }

    // Unenrolls the students and removes the instructor.
    public void endCourse() {
        for (Student student : enrolledStudents) {
            student.setEnrolledCourse(null);
        }

        enrolledStudents = new ArrayList<>();

        if (instructor != null) {
            instructor.unassignCourse();
            instructor = null;
        }
    }
}
