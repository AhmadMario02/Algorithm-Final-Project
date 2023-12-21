import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String guestName, studentsName;
        System.out.println("Welcome to Guest Receptionist");
        System.out.print("Please insert your name: ");
        guestName = input.nextLine();
        System.out.println("Next, please insert your child name: ");
        studentsName = input.nextLine();
        System.out.println(guestName);
        System.out.println(studentsName);
    }
}