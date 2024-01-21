import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Review {

    QuestionsClass questions = new QuestionsClass();
    private String studentId;
    private String courseName;
    private String teacherName;
    private String questionSetType;
    private Integer questionOne;
    private Integer questionTwo;
    private Integer questionThree;
    private Integer questionFour;
    private Integer questionFive;

    public Review(String studentId, String courseName, String teacherName, String questionSetType) {
        this.studentId = studentId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.questionSetType = questionSetType;
    }

    public void displayQuestionSet() {
        System.out.println("Question set for " + courseName + " - " + teacherName);
        System.out.println("Please answer the following questions in the scale from 1 to 5 with 1 being the worst and 5 being the best: ");
        switch (questionSetType.toLowerCase()) {
            case "lecture":
                displayLectureQuestions();
                break;
            case "lab":
                displayLabQuestions();
                break;
            case "tutorial":
                displayTutorialQuestions();
                break;
            default:
                System.out.println("Invalid question set type.");
        }

    }
    private void displayLectureQuestions() {
        questionOne = askQuestion(questions.lectureQuestionsArray[0]);
        questionTwo = askQuestion(questions.lectureQuestionsArray[1]);
        questionThree = askQuestion(questions.lectureQuestionsArray[2]);
        questionFour = askQuestion(questions.lectureQuestionsArray[3]);
        questionFive = askQuestion(questions.lectureQuestionsArray[4]);
    }

    private void displayTutorialQuestions() {
        questionOne = askQuestion(questions.tutorialQuestionsArray[0]);
        questionTwo = askQuestion(questions.tutorialQuestionsArray[1]);
        questionThree = askQuestion(questions.tutorialQuestionsArray[2]);
        questionFour = askQuestion(questions.tutorialQuestionsArray[3]);
        questionFive = askQuestion(questions.tutorialQuestionsArray[4]);
    }

    private void displayLabQuestions() {
        questionOne = askQuestion(questions.labQuestionsArray[0]);
        questionTwo = askQuestion(questions.labQuestionsArray[1]);
        questionThree = askQuestion(questions.labQuestionsArray[2]);
        questionFour = askQuestion(questions.labQuestionsArray[3]);
        questionFive = askQuestion(questions.labQuestionsArray[4]);
    }

    private Integer askQuestion(String question) {
        System.out.println(question);
        return getUserInput();
    }

    private Integer getUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();
                if (userInput >= 1 && userInput <= 5) {
                    return userInput;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number between 1 and 5.");
                scanner.next();
            }
        }
    }


    public Integer calculateTotal(){
        return (questionOne + questionTwo + questionThree + questionFour + questionFive)*4;
    }


    public void writeReviewToCSV() {
        CsvHelper csvHelper = new CsvHelper("reviews.csv");

        List<String[]> newData = new ArrayList<>();
        newData.add(new String[]{
                studentId,
                teacherName,
                courseName,
                questionSetType,
                questionOne.toString(),
                questionTwo.toString(),
                questionThree.toString(),
                questionFour.toString(),
                questionFive.toString(),
                calculateTotal().toString()
        });

        // Update the CSV file with the new data
        csvHelper.writeData(newData);
        System.out.println("Review submitted successfully.");
    }


}
