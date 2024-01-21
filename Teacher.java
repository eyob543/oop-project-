// Teacher class
public class Teacher {
    private int id;
    private String name;
    private String courseName;

    // Constructor
    public Teacher(int id, String name, String courseName) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
