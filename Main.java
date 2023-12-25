import java.util.*;
public class Main {
    public static void main(String[] args) {
        Student ahmad = new Student("Ahmad", "Yahya");
        Student ihsan = new Student("Ihsan", "Alawy");
        Student noor = new Student("Noor", "Yahya");
        Student yazed = new Student("Yazed", "Nouman");

        Scanner input = new Scanner(System.in);
        String guestName, studentsName;
        System.out.println("Welcome to Guest Receptionist");
        System.out.println("Input 1 to continue.\nInput 0 to entering Administator.");
        int menu = input.nextInt();
        input.nextLine();
        if (menu == 1) {    
            System.out.println("Please insert your name: ");
            guestName = input.nextLine();
            System.out.println("Next, please insert your child name: ");
            studentsName = input.nextLine();
            System.out.println("Guest Name" + guestName);
            System.out.println("Child Name" + studentsName);
            input.close();
        }
    }
}