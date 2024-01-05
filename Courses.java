import java.util.ArrayList;

public class Courses {
    ArrayList<ArrayList<Integer>> listOfCourses = new ArrayList<>();
    ArrayList<Integer> listOfCourses1 = new ArrayList<>();
    ArrayList<Integer> listOfCourses2 = new ArrayList<>();
    ArrayList<Integer> listOfCourses3 = new ArrayList<>();
    ArrayList<Integer> listOfCourses4 = new ArrayList<>();
    ArrayList<Integer> listOfCourses5 = new ArrayList<>();
    ArrayList<Integer> listOfCourses6 = new ArrayList<>();
    ArrayList<Integer> listOfCourses7 = new ArrayList<>();

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
        listOfCourses.add(listOfCourses1);
        listOfCourses.add(listOfCourses2);
        listOfCourses.add(listOfCourses3);
        listOfCourses.add(listOfCourses4);
        listOfCourses.add(listOfCourses5);
        listOfCourses.add(listOfCourses6);
        listOfCourses.add(listOfCourses7);
    }

    // Other methods can go here...

    // The array to store courses to be evaluated
    String[] coursesToBeEvaluated = new String[7];
}
