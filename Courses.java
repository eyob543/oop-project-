import java.util.ArrayList;

public class Courses {
   ArrayList<ArrayList<String>> listOfCourses = new ArrayList<>();
   private ArrayList<String> listOfCourses1 = new ArrayList<>();
   private ArrayList<String> listOfCourses2 = new ArrayList<>();
   private ArrayList<String> listOfCourses3 = new ArrayList<>();
   private ArrayList<String> listOfCourses4 = new ArrayList<>();
   private ArrayList<String> listOfCourses5 = new ArrayList<>();
   private ArrayList<String> listOfCourses6 = new ArrayList<>();
   private ArrayList<String> listOfCourses7 = new ArrayList<>();
    //sets what the user has inputed to the array list
    void setCourse1Evaluation(String evaluation){
        listOfCourses1.add(evaluation);
    }
    void setCourse2Evaluation(String evaluation){
        listOfCourses2.add(evaluation);
    }
    void setCourse3Evaluation(String evaluation){
        listOfCourses3.add(evaluation);
    }
    void setCourse4Evaluation(String evaluation){
        listOfCourses4.add(evaluation);
    }
    void setCourse5Evaluation(String evaluation){
        listOfCourses5.add(evaluation);
    }
    void setCourse6Evaluation(String evaluation){
        listOfCourses6.add(evaluation);
    }
    void setCourse7Evaluation(String evaluation){
        listOfCourses7.add(evaluation);
    }
    //gets what the students have said about the course
    void getCourse1Evaluation(int index){
        listOfCourses1.get(index);
    }
    void getCourse2Evaluation(int index){
        listOfCourses2.get(index);
    }
    void getCourse3Evaluation(int index){
        listOfCourses3.get(index);
    }
    void getCourse4Evaluation(int index){
        listOfCourses4.get(index);
    }
    void getCourse5Evaluation(int index){
        listOfCourses5.get(index);
    }
    void getCourse6Evaluation(int index){
        listOfCourses6.get(index);
    }
    void getCourse7Evaluation(int index){
        listOfCourses6.get(index);
    }
    String[] coursesToBeEvaluated = new String[7]; 
    Courses(String[] courses){
        this.coursesToBeEvaluated[0] = courses[0];
        this.coursesToBeEvaluated[1] = courses[1];
        this.coursesToBeEvaluated[2] = courses[2];
        this.coursesToBeEvaluated[3] = courses[3];
        this.coursesToBeEvaluated[4] = courses[4];
        this.coursesToBeEvaluated[5] = courses[5];
        this.coursesToBeEvaluated[6] = courses[6];
    }
}
