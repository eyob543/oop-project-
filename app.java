import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        //Creates a student class
        StudentClass studentClass = new StudentClass();
        //Creates a courses class
        Courses prototypeCourses = new Courses(new String[]{"O.O.P", "AE1", "E.M.F", "Computational", "WorkShop", "Research", "Signals"});
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your section: ");
        char section = scanner.next().charAt(0);
        //Checking if the student is in section a or b
        if(section == 'a' || section == 'A'){
            System.out.print("Enter your Id number: ");
            String section_A_ID  = scanner.next(); 
            //loops over the array of ID numbers and checks if the input is in the array if so it continues
            for (int i = 0; i < studentClass.section_A_Students.length; i++) {

                if(studentClass.section_A_Students[i].equals(section_A_ID)){
                    System.out.print("Which course do you want to evaluate: ");
                    String courseToEvaluate = scanner.next();
                    for (int j = 0; j < prototypeCourses.coursesToBeEvaluated.length; j++) {
                        if( prototypeCourses.coursesToBeEvaluated[j].equalsIgnoreCase(courseToEvaluate)){
                            System.out.println("Please answer the following questions truthfully: ");
                            break;
                            //TODO ADD QUESTION HERE!
                        }else if(j +1 == prototypeCourses.coursesToBeEvaluated.length){
                            //checks if the end of the array has been reached and prints no such course
                            System.out.println("No such course");
                        }
                    }
                    break;
                }else if(i + 1 == studentClass.section_A_Students.length){
                    //IF THE ID IS NOT FOUND
                    System.out.println("Invalid ID");
                }
            }
        }else if(section == 'b' || section == 'B'){
            System.out.print("Enter your Id number: ");
            String section_B_ID  = scanner.next(); 
           for (int i = 0; i < studentClass.section_B_Students.length; i++) {
                if(studentClass.section_B_Students[i].equals(section_B_ID)){
                    System.out.print("Which course do you want to evaluate: ");
                    String courseToEvaluate = scanner.next();
                    break;
                }else if(i + 1 == studentClass.section_B_Students.length){
                    //IF THE ID IS NOT FOUND
                    System.out.println("Invalid ID");
                }
            }
        }else{
            System.out.println("You are not in neither section a or b");
        }
        scanner.close();
    }
}
