import java.util.Arrays;
import java.util.Random;

// The Administrator class.
public class Administrator {
    private School school;

    // The constructor for Administrator.
    public Administrator(String name) {
        school = new School(name);
    }

    // Runs the simulation for a day.
    public void run() {
        Random rand = new Random();

        // Adds up to two new students to the school.
        for (int i = 0; i < rand.nextInt(2) + 1; i++) {
            school.add(new Student("Ross", 'M', 32));
        }

        // Adds new instructors to the school.
        if (rand.nextFloat() <= 0.2) {
            school.add(new Teacher("Chandler", 'M', 29));
        }
        if (rand.nextFloat() <= 0.1) {
            school.add(new Teacher("Rachael", 'F', 31));
        }
        if (rand.nextFloat() <= 0.05) {
            school.add(new Teacher("Monica", 'F', 30));
        }
        if (rand.nextFloat() <= 0.05) {
            school.add(new Teacher("Phoebe", 'F', 32));
        }

        // Runs a day at school.
        school.aDayAtSchool();

        // Might remove a spare teacher.
        for (Instructor instructor : school.getInstructors()) {
            if (instructor.getAssignedCourse() == null && rand.nextFloat() <= 0.2) {
                school.remove(instructor);
                break;
            }
        }

        // Might remove a student.
        for (Student student : school.getStudents()) {
            boolean studying = false;

            // Removes any graduates that have a certificate in every course.
            if (student.getCertificates().size() == school.getSubjects().size() && school.getSubjects().size() > 0) {
                System.out.println(student.getName());
                school.remove(student);
                break;
            }

            // Checks if the student is taking a course.
            for (Course course : school.getCourses()) {
                if (Arrays.asList(course.getStudents()).contains(student)) {
                    studying = true;
                }
            }

            // Might remove a spare student.
           if (!studying && rand.nextFloat() <= 0.05) {
                school.remove(student);
                break;
           }
        }
    }

    // Runs the simulation for a given number of days.
    public void run(int days) {
        for (int i = 0; i < days; i++) {
            run();

            // Prints information about courses.
            for (Course course : school.getCourses()) {
                System.out.println("Course: " + course.getStatus() + " " + Arrays.toString(course.getStudents()));
            }

            // Prints information about students.
            for (Student student : school.getStudents()) {
                System.out.println("Student: " + student.getCertificates() + " " + student.getEnrolledCourse());
            }

            // Prints information about instructors.
            for (Instructor instructor : school.getInstructors()) {
                System.out.println("Instructor: " + instructor.getAssignedCourse());
            }
        }
    }

    // Main method to run the simulation.
    public static void main(String[] args) {
        try
        {
            Thread.sleep(500);
            Administrator administrator = new Administrator("Calthorpe Park School");
            administrator.run(3);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
