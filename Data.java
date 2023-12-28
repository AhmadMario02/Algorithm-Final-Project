import java.util.*;
public class Data {
    Scanner input = new Scanner(System.in);
    List<Student> allstudents = new ArrayList<Student>();
    List<SiblingsGroup> allGroup = new ArrayList<SiblingsGroup>();
    
    Student ahmad = new Student("Ahmad", "Yahya");
    Student yazed = new Student("Yazed", "Nouman");
    Student noor = new Student("Noor", "Yahya");
    Student ihsan = new Student("Ihsan", "Alawy");
    Student jafar = new Student("Jafar", "Alawy");
    Student hasan = new Student("Hasan", "Alawy");

    
    SiblingsGroup nouman = new SiblingsGroup("Nouman", new ArrayList<>(List.of(yazed)));
    SiblingsGroup yahya = new SiblingsGroup("Yahya", new ArrayList<>(List.of(ahmad, noor)));
    SiblingsGroup alawy = new SiblingsGroup("Alawy", new ArrayList<>(List.of(ihsan, jafar, hasan)));

    public Data(){
        allGroup.add(alawy);
        allGroup.add(yahya);
        allGroup.add(nouman);
        allstudents.add(ahmad);
        allstudents.add(ihsan);
        allstudents.add(noor);
        allstudents.add(yazed);
        allstudents.add(jafar);
        allstudents.add(hasan);
    }

    public void addNewStudents(){
        System.out.println("Please input the student name: ");
        String name = input.nextLine();
        System.out.println("Please input the family name: ");
        String family = input.nextLine();
        Student newStudent = new Student(name, family);
        allstudents.add(newStudent);
        System.out.println("Do you want to add into family group? Y/N");
        char select = input.next().charAt(0);
        switch (select) {
            case 'Y':
            int ind = 1;
            System.out.println("yes, yello");
            System.out.println("Select the family:");
            for(SiblingsGroup sg : allGroup){
                System.out.println(ind + ". " + sg.getFamilyName());
                ind++;
            }
            break;
            case 'N':
            System.out.println("no, nigg*");  
            break;
            default:
            System.out.println("Invalid input!");
            break;
        }
    }

    public void printAllStudents(){
        for (int i = 0; i < allstudents.size(); i++) {
            System.out.println(allstudents.get(i).getName()+ "\tBin " + allstudents.get(i).getFamilyName());
        }
    }

    public int totalStudents(){
        return allstudents.size();
    }

    public void call(String studentsName){
        int indexsg = 0, keysg = -1, ks = 0;
        for (SiblingsGroup sg : allGroup){
            int indexs = 0, keys = -1;
            for (Student s : sg.getFamilyList()) {
                if (s.getName().equalsIgnoreCase(studentsName)) {
                    // System.out.println("We found it at " + indexs + ", " + indexsg);
                    keys = ks = indexs;
                    keysg = indexsg;
                    break;
                }
                indexs++;
                // System.out.println("Index Student: "+indexs);
            }
            indexsg++;
            // System.out.println("Index Group: " + indexsg);
        }

        System.out.println(allGroup.get(keysg).getFamilyName() + "'s family visit: " + allGroup.get(keysg).getVisitCount());
        if (allGroup.get(keysg).getVisitCount() < 2) {
                allGroup.get(keysg).getFamilyList().get(ks).visit();
                allGroup.get(keysg).visit();
                System.out.println("Times visited for "+allGroup.get(keysg).getFamilyList().get(ks).getName() + " is: " + allGroup.get(keysg).getFamilyList().get(ks).getVisitCount());
        } else System.out.println("Your visit has approach limit");
    }
}