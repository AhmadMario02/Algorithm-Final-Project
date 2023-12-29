//This whole program code written by: Ahmad Mario for completing requirement of Data Structure & Algorithm Final Exam.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Scanner input = new Scanner(System.in);
        String familyName, studentsName;
        int menu;
        do {
            System.out.println("\nWelcome to Guest Receptionist");
            System.out.println("\nInput 1 to continue.\nInput 2 to entering Administator.");
            System.out.print("Your input goes here -> ");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1:
                System.out.println("Please insert your child name: ");
                studentsName = input.nextLine();
                System.out.println("Next, please insert your family name: ");
                familyName = input.nextLine();
                System.out.println("__________________________");
                System.out.println("Child Name: " + studentsName + " Bin " + familyName + "\n");
                data.call(studentsName);
                break;
                
                case 2:
                System.out.println("Welcome to Administration Mode.\nSelect Menu:");
                System.out.println("1. Add Student");
                System.out.println("2. Delete Student");
                System.out.println("3. Print All Student");
                System.out.print("Your input goes here -> ");
                menu = input.nextInt();
                switch (menu) {
                    case 1:
                    data.addNewStudents();    
                    break;
                    case 2:
                    data.delete();
                    break;
                    case 3:
                    System.out.println("______________________________________");
                    System.out.println("Total of all students right now is: " + data.totalStudents());
                    data.printAllStudents();
                    break;
                    default:
                    break;
                }
                break;
                
                case 0:
                System.out.println("Have a nice day!");
                break;

                default:
                System.out.println("Invalid input");
                break;
            }  
        } while (menu != 0);
        input.close();
        
    }
}