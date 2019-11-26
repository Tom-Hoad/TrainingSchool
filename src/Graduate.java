// The Graduate class. Subclass to the Student class.
public class Graduate extends Student {
    private int graduationDay;

    // The constructor for Graduate, inherited from Student.
    public Graduate(String name, char gender, int age) {
        super(name, gender, age);
    }

    // Gets the day of graduation.
    public int getGraduationDay() {
        return graduationDay;
    }

    // Sets the day of graduation.
    public void setGraduationDay(int graduationDay) {
        this.graduationDay = graduationDay;
    }
}
