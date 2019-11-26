// The Graduate class. Subclass to the Student class.
public class Graduate extends Student {
    private int graduationDay;

    // The constructor for Graduate, inherited from Student.
    public Graduate(String name, char gender, int age, int graduationDay) {
        super(name, gender, age);
        this.graduationDay = graduationDay;
    }
}
