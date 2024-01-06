 import java.io.*;
import java.util.ArrayList;

public class Courses {
    ArrayList<ArrayList<Integer>> listOfCourses = new ArrayList<>();
    ArrayList<Integer> course1 = new ArrayList<>();
    ArrayList<Integer> course2 = new ArrayList<>();
    ArrayList<Integer> course3 = new ArrayList<>();
    ArrayList<Integer> course4 = new ArrayList<>();
    ArrayList<Integer> course5 = new ArrayList<>();
    ArrayList<Integer> course6 = new ArrayList<>();
    ArrayList<Integer> course7 = new ArrayList<>();

    // Constructor
    public Courses(String[] courses) {
        this.coursesToBeEvaluated[0] = courses[0];
        this.coursesToBeEvaluated[1] = courses[1];
        this.coursesToBeEvaluated[2] = courses[2];
        this.coursesToBeEvaluated[3] = courses[3];
        this.coursesToBeEvaluated[4] = courses[4];
        this.coursesToBeEvaluated[5] = courses[5];
        this.coursesToBeEvaluated[6] = courses[6];

        // Adding ArrayLists to listOfCourses
        listOfCourses.add(course1);
        listOfCourses.add(course2);
        listOfCourses.add(course3);
        listOfCourses.add(course4);
        listOfCourses.add(course5);
        listOfCourses.add(course6);
        listOfCourses.add(course7);
    }
    Courses(){

    }
    // Other methods can go here...

    // The array to store courses to be evaluated
    String[] coursesToBeEvaluated = new String[7];
    // Save reviews to a file
 public void saveReviews() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("reviews.dat"))) {
            oos.writeObject(listOfCourses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load reviews from a file
    public void loadReviews() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("reviews.dat"))) {
            listOfCourses = (ArrayList<ArrayList<Integer>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If the file doesn't exist or there's an issue reading it, ignore and continue with an empty list
            listOfCourses = new ArrayList<>();
        }
    }
     // Retrieve reviews for a specific course
     public ArrayList<Integer> getReviewsForCourse(int index) {
        return listOfCourses.get(index);
    }
}
