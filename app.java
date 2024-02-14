import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class app {
    // Creates a student class
    StudentClass studentClass = new StudentClass();
    private static final String CSV_FILE_PATH = "reviews.csv";
    private static final CsvHelper csvHelper = new CsvHelper(CSV_FILE_PATH);
    // Creates a courses class
    private ArrayList<Teacher> teachers;
    private ArrayList<Course> courses;

    // Constructor
    public app() {
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }

    // Method to add a teacher to the list
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    // Method to add a course to the list
    public void addCourse(Course course) {
        courses.add(course);
    }

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createCsvFileIfNotExists();
        app app = new app();

        app.addTeacher(new Teacher(1, "Bereket Dawit", "AE1"));
        app.addTeacher(new Teacher(2, "Solomon Getaye", "AE1"));
        app.addTeacher(new Teacher(3, "Selam Belay", "Workshop"));
        app.addTeacher(new Teacher(4, "Dagam Girma", "O.O.P"));
        app.addTeacher(new Teacher(5, "Helen Zewdu", "O.O.P"));
        app.addTeacher(new Teacher(6, "Almaz Yehun", "Computational Methods"));
        app.addTeacher(new Teacher(7, "Biniyam Tesfaye", "E.M.F"));
        app.addTeacher(new Teacher(8, "Aster Abebe", "Research"));

        app.addCourse(new Course(101, "AE1"));
        app.addCourse(new Course(102, "Workshop"));
        app.addCourse(new Course(103, "O.O.P"));
        app.addCourse(new Course(104, "Computational Methods"));
        app.addCourse(new Course(105, "E.M.F"));
        app.addCourse(new Course(106, "Research"));



        System.out.print("Welcome! \nPlease enter 'S' if you are a student, 'A' if you are an administrator or 'T' if you are a teacher: ");
        String response = app.scanner.nextLine();
        if (response.equalsIgnoreCase("S")) {
            app.studentFunction();
        } else if (response.equalsIgnoreCase("A")) {
            app.adminFunction();
        } else if (response.equalsIgnoreCase("T")) {
            app.teacherFunction();
        }

    }

    private static void createCsvFileIfNotExists() {
        File file = new File(CSV_FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean hasPreviousEntry(List<String[]> existingData, String studentId, String teacher, String course, String questionSet) {
        for (String[] row : existingData) {
            if (row[0].equals(studentId) && row[1].equals(course) && row[2].equals(teacher) && row[3].equals(questionSet)) {
                return true; // previous entry
            }
        }
        return false; // No previous entry
    }

    public void studentFunction() {
        System.out.print("Enter your section e.g 'A' or 'B': ");
        char section = scanner.next().charAt(0);

        if (section == 'a' || section == 'A') {
            System.out.print("Enter your Id number e.g (A001): ");
            String section_A_ID = scanner.next();

            for (int i = 0; i < studentClass.section_A_Students.length; i++) {
                if (studentClass.section_A_Students[i].equals(section_A_ID)) {
                    evaluationFunction(section_A_ID);
                    break;
                } else if (i + 1 == studentClass.section_A_Students.length) {
                    System.out.println("Invalid ID");
                }
            }
        } else if (section == 'b' || section == 'B') {
            System.out.print("Enter your Id number e.g. (B001): ");
            String section_B_ID = scanner.next();
            for (int i = 0; i < studentClass.section_B_Students.length; i++) {
                if (studentClass.section_B_Students[i].equals(section_B_ID)) {
                    evaluationFunction(section_B_ID);
                    break;
                } else if (i + 1 == studentClass.section_B_Students.length) {
                    System.out.println("Invalid ID. Try again later!");
                }
            }
        } else {
            System.out.println("You are not in neither section a or b");
        }
    }


    public void evaluationFunction(String studentID) {
        int userChoice;

        do {
            System.out.print("Enter the number corresponding to the course (or enter 0 to exit): \n");

            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
            }

            userChoice = scanner.nextInt();

            if (userChoice == 0) {
                System.out.println("Exiting course evaluation.");
                return;
            } else if (userChoice >= 1 && userChoice <= courses.size()) {
                int indexOfTheCourse = userChoice - 1;
                Course selectedCourse = courses.get(indexOfTheCourse);

                System.out.println("Evaluating course: " + selectedCourse.getCourseName());

                ArrayList<Teacher> teachersForCourse = getTeachersForCourse(selectedCourse);

                System.out.print("Enter the number corresponding to the teacher: \n");
                for (int i = 0; i < teachersForCourse.size(); i++) {
                    System.out.println((i + 1) + ". " + teachersForCourse.get(i).getName());
                }

                int teacherChoice = scanner.nextInt();
                if (teacherChoice >= 1 && teacherChoice <= teachersForCourse.size()) {
                    int indexOfTheTeacher = teacherChoice - 1;
                    Teacher selectedTeacher = teachersForCourse.get(indexOfTheTeacher);

                    // Print the chosen teacher's name
                    System.out.println("Selected teacher: " + selectedTeacher.getName());


                    System.out.println("Select the type of questions:");
                    System.out.println("1. Tutorial Questions");
                    System.out.println("2. Lab Questions");
                    System.out.println("3. Lecture Questions");
                    System.out.println("4. Back to course menu");

                    int questionTypeChoice = scanner.nextInt();

                    switch (questionTypeChoice) {
                        case 1:
                            handleReview(studentID, selectedTeacher.getName(), selectedCourse.getCourseName(), "tutorial");
                            break;
                        case 2:
                            handleReview(studentID, selectedTeacher.getName(), selectedCourse.getCourseName(), "lab");
                            break;
                        case 3:
                            handleReview(studentID, selectedTeacher.getName(), selectedCourse.getCourseName(), "lecture");
                            break;
                        case 4:
                            // Back to course selection
                            System.out.println("Going back to course selection.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose a valid option.");
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please choose a valid teacher.");
                }


            } else {
                System.out.println("Invalid choice. Please choose a number corresponding to the course (or enter 0 to exit).");
            }
        } while (true); // Infinite loop until a valid choice or exit option is made
    }

    private ArrayList<Teacher> getTeachersForCourse(Course course) {
        ArrayList<Teacher> teachersForCourse = new ArrayList<>();
        //filter
        for (Teacher teacher : teachers) {
            if (teacher.getCourseName().equalsIgnoreCase(course.getCourseName())) {
                teachersForCourse.add(teacher);
            }
        }

        return teachersForCourse;
    }

    public Teacher getTeacherByName(String teacherName) {
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(teacherName)) {
                return teacher;
            }
        }
        return null; // Teacher not found
    }


    private void handleReview(String studentId, String courseName, String teacherName, String questionSet) {
        List<String[]> existingData = csvHelper.readData();

        if (!hasPreviousEntry(existingData, studentId, teacherName, courseName, questionSet)) {
            Review review = new Review(studentId, teacherName, courseName, questionSet);
            review.displayQuestionSet();
            review.writeReviewToCSV();
            System.out.println("You have successfully submitted a review!");
            System.exit(0);
        } else {
            System.out.println("A review with the same combinations already exists. You cannot submit a duplicate review.");
        }
    }

    private void showReview(String courseName, String teacherName, String questionSet) {
        List<String[]> existingData = csvHelper.readData();

        double totalQOne = 0;
        double totalQTwo = 0;
        double totalQThree = 0;
        double totalQFour = 0;
        double totalQFive = 0;
        double totalOfTotal = 0;
        int totalReviews = 0;

        System.out.println("Showing review for " + courseName + " - " + teacherName + " - " + questionSet);

        for (int i = 0; i < existingData.size(); i++) {
            String[] row = existingData.get(i);
            if (row[1].equalsIgnoreCase(courseName) && row[2].equalsIgnoreCase(teacherName) && row[3].equalsIgnoreCase(questionSet)) {

                int questionOne = Integer.parseInt(row[4]);
                totalQOne += questionOne;
                int questionTwo = Integer.parseInt(row[5]);
                totalQTwo += questionTwo;
                int questionThree = Integer.parseInt(row[6]);
                totalQThree += questionThree;
                int questionFour = Integer.parseInt(row[7]);
                totalQFour += questionFour;
                int questionFive = Integer.parseInt(row[8]);
                totalQFive += questionFive;
                int total = Integer.parseInt(row[9]);
                totalOfTotal += total;
                totalReviews++;


            }
        }

        if (totalReviews > 0) {
            QuestionsClass questions = new QuestionsClass();
            switch (questionSet.toLowerCase()) {
                case "lecture":
                    System.out.println("1. " + questions.lectureQuestionsArray[0] + " - " + totalQOne / totalReviews + "/5.");
                    System.out.println("2. " + questions.lectureQuestionsArray[1] + " - " + totalQTwo / totalReviews + "/5.");
                    System.out.println("3. " + questions.lectureQuestionsArray[2] + " - " + totalQThree / totalReviews + "/5.");
                    System.out.println("4. " + questions.lectureQuestionsArray[3] + " - " + totalQFour / totalReviews + "/5.");
                    System.out.println("5. " + questions.lectureQuestionsArray[4] + " - " + totalQFive / totalReviews + "/5.");
                    System.out.println("Total Score - " + totalOfTotal / totalReviews + "/100.\n");
                    break;
                case "lab":
                    System.out.println("1. " + questions.labQuestionsArray[0] + " - " + totalQOne / totalReviews + "/5.");
                    System.out.println("2. " + questions.labQuestionsArray[1] + " - " + totalQTwo / totalReviews + "/5.");
                    System.out.println("3. " + questions.labQuestionsArray[2] + " - " + totalQThree / totalReviews + "/5.");
                    System.out.println("4. " + questions.labQuestionsArray[3] + " - " + totalQFour / totalReviews + "/5.");
                    System.out.println("5. " + questions.labQuestionsArray[4] + " - " + totalQFive / totalReviews + "/5.");
                    System.out.println("Total Score - " + totalOfTotal / totalReviews + "/100.\n");

                    break;
                case "tutorial":
                    System.out.println("1. " + questions.tutorialQuestionsArray[0] + " - " + totalQOne / totalReviews + "/5.");
                    System.out.println("2. " + questions.tutorialQuestionsArray[1] + " - " + totalQTwo / totalReviews + "/5.");
                    System.out.println("3. " + questions.tutorialQuestionsArray[2] + " - " + totalQThree / totalReviews + "/5.");
                    System.out.println("4. " + questions.tutorialQuestionsArray[3] + " - " + totalQFour / totalReviews + "/5.");
                    System.out.println("5. " + questions.tutorialQuestionsArray[4] + " - " + totalQFive / totalReviews + "/5.");
                    System.out.println("Total Score - " + totalOfTotal / totalReviews + "/100.\n");
                    break;
                default:
                    System.out.println("Invalid question set type.");
            }
        } else {
            System.out.println("No reviews found for the specified combination.");
        }
    }


    void adminFunction() {
        String password = "admin";
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        while (!inputPassword.equals(password)) {
            System.out.println("Incorrect password try again: ");
            System.out.print("Enter password: ");
            inputPassword = scanner.nextLine();
        }

        int userChoice;

        do {
            System.out.print("Enter the number corresponding to the course to view reviews (or enter 0 to exit): \n");

            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
            }

            userChoice = scanner.nextInt();

            if (userChoice == 0) {
                System.out.println("Exiting...");
                return;
            } else if (userChoice >= 1 && userChoice <= courses.size()) {
                int indexOfTheCourse = userChoice - 1;
                Course selectedCourse = courses.get(indexOfTheCourse);

                System.out.println("Selected course: " + selectedCourse.getCourseName());

                ArrayList<Teacher> teachersForCourse = getTeachersForCourse(selectedCourse);

                System.out.print("Enter the number corresponding to the teacher: \n");
                for (int i = 0; i < teachersForCourse.size(); i++) {
                    System.out.println((i + 1) + ". " + teachersForCourse.get(i).getName());
                }

                int teacherChoice = scanner.nextInt();
                if (teacherChoice >= 1 && teacherChoice <= teachersForCourse.size()) {
                    int indexOfTheTeacher = teacherChoice - 1;
                    Teacher selectedTeacher = teachersForCourse.get(indexOfTheTeacher);

                    // Print the chosen teacher's name
                    System.out.println("Selected teacher: " + selectedTeacher.getName());


                    System.out.println("Select the type of questions:");
                    System.out.println("1. Tutorial Questions");
                    System.out.println("2. Lab Questions");
                    System.out.println("3. Lecture Questions");
                    System.out.println("4. Back to course menu");

                    int questionTypeChoice = scanner.nextInt();

                    switch (questionTypeChoice) {
                        case 1:
                            showReview(selectedTeacher.getName(), selectedCourse.getCourseName(), "tutorial");
                            break;
                        case 2:
                            showReview(selectedTeacher.getName(), selectedCourse.getCourseName(), "lab");
                            break;
                        case 3:
                            showReview(selectedTeacher.getName(), selectedCourse.getCourseName(), "lecture");
                            break;
                        case 4:
                            // Back to course selection
                            System.out.println("Going back to course selection.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose a valid option.");
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please choose a valid teacher.");
                }


            } else {
                System.out.println("Invalid choice. Please choose a number corresponding to the course (or enter 0 to exit).");
            }
        } while (true);

    }

    void teacherFunction() {
        System.out.print("Enter your name: ");
        String inputName = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        while (!inputPassword.equals(inputName)) {
            System.out.println("Incorrect password try again: ");
            System.out.print("Enter password: ");
            inputPassword = scanner.nextLine();
        }

        int userChoice;

        do {
            Teacher teacher = getTeacherByName(inputName);

            if (teacher == null) {
                System.out.println("Error: Teacher not found.");
                System.exit(0);
            }

            System.out.println("Select the type of course (0 to exit):");
            System.out.println("1. Tutorial Questions");
            System.out.println("2. Lab Questions");
            System.out.println("3. Lecture Questions");

            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    showReview(teacher.getName(), teacher.getCourseName(), "tutorial");
                    break;
                case 2:
                      showReview(teacher.getName(), teacher.getCourseName(), "lab");
                    break;
                case 3:
                    showReview(teacher.getName(), teacher.getCourseName(), "lecture");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }


        } while (true);

    }


}
