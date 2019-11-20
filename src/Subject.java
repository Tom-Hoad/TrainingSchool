// The Subject class.
public class Subject {
    private int id;
    private int specialism;
    private int duration;
    private String description;

    // The constructor for a subject. Takes the id, specialism and duration.
    public Subject(int id, int specialism, int duration) {
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
    }

    // Gets the subject id.
    public int getID() {
        return id;
    }

    // Gets the specialism id.
    public int getSpecialism() {
        return specialism;
    }

    // Gets the course duration.
    public int getDuration() {
        return duration;
    }

    // Gets the course description.
    public String getDescription() {
        return description;
    }

    // Sets the course description.
    public void setDescription(String description) {
        this.description = description;
    }
}
