import java.util.Scanner;

public class app {
    // Creates a student class
    StudentClass studentClass = new StudentClass();
    // Creates a courses class
    Courses prototypeCourses = new Courses(new String[]{"O.O.P", "AE1", "E.M.F", "Computational", "WorkShop", "Research", "Signals"});
    Scanner scanner = new Scanner(System.in);
    QuestionsClass questions = new QuestionsClass();
    public static void main(String[] args) {
        app app = new app();
        app.run();
    }
    //checkes the students section and asks them which course they want to evaluate
    public void run() {
        System.out.print("Enter your section: ");
        char section = scanner.next().charAt(0);

        if (section == 'a' || section == 'A') {
            System.out.print("Enter your Id number: ");
            String section_A_ID = scanner.next();

            for (int i = 0; i < studentClass.section_A_Students.length; i++) {
                if (studentClass.section_A_Students[i].equals(section_A_ID)) {
                    evaluationFunction();
                    break;
                } else if (i + 1 == studentClass.section_A_Students.length) {
                    System.out.println("Invalid ID");
                }
            }
        } else if (section == 'b' || section == 'B') {
            System.out.print("Enter your Id number: ");
            String section_B_ID = scanner.next();
            for (int i = 0; i < studentClass.section_B_Students.length; i++) {
                if (studentClass.section_B_Students[i].equals(section_B_ID)) {
                    evaluationFunction();
                    break;
                } else if (i + 1 == studentClass.section_B_Students.length) {
                    System.out.println("Invalid ID");
                }
            }
        } else {
            System.out.println("You are not in neither section a or b");
        }
        // scanner.close();
    }

    public void evaluationFunction() {
        System.out.print("Which course do you want to evaluate: ");
        String courseToEvaluate = scanner.next();
        for (int j = 0; j < prototypeCourses.coursesToBeEvaluated.length; j++) {
            if (prototypeCourses.coursesToBeEvaluated[j].equalsIgnoreCase(courseToEvaluate)) {
                int indexOfTheCourse = j;
                questionsFunction(indexOfTheCourse, courseToEvaluate);
                break;
                // TODO ADD QUESTION HERE!
            } else if (j + 1 == prototypeCourses.coursesToBeEvaluated.length) {
                System.out.println("No such course");
            }
        }
    }
    public void questionsFunction(int index, String course){
        System.out.println("Please answer the following questions in the scale from 1 to 5 with 1 being the worst and 5 being the best: ");
        //loops through the questions and sets the rating to the respective to the course
        for (String question : questions.questionsArray) {
            System.out.println(question);
            int rating = scanner.nextInt();
            prototypeCourses.listOfCourses.get(index).add(rating);
        }
        System.out.println("You gave " + course + " "+ calculateThePercentage(index) + "%");
    }
    public double calculateThePercentage(int index){
        //made it a double since it would be zero 
        double sum = 0;
        for (double rating : prototypeCourses.listOfCourses.get(index)) {
            sum += rating;
        }
        //This code assumes that the ratings are on a scale from 1 to 5 and that there are 10 questions (hence the division by 50 to get a percentage out of 100%). 
        double percentage = (sum / 50) * 100;
        return percentage;
    }
}
