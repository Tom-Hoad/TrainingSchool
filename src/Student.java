import java.util.ArrayList;

// The Student class. Subclass to Person class.
public class Student extends Person {
    private ArrayList<Integer> certificates;

    // The inherited constructor for Student from Person. Initialises the certificates ArrayList.
    public Student(String name, char gender, int age) {
        super(name, gender, age);
        certificates = new ArrayList<>();
    }

    // Adds the subject id to certificates ArrayList.
    public void graduate(Subject subject) {
        if (!hasCertificate(subject)) {
            certificates.add(subject.getID());
        }
    }

    // Gets the certificates ArrayList.
    public ArrayList<Integer> getCertificates() {
        return certificates;
    }

    // Checks if the student has a certificate.
    public boolean hasCertificate(Subject subject) {
        for (int i : certificates) {
            if (subject.getID() == i) {
                return true;
            }
        }
        return false;
    }
}
