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

    
    SiblingsGroup nouman = new SiblingsGroup("Nouman", new ArrayList<>());
    SiblingsGroup yahya = new SiblingsGroup("Yahya", new ArrayList<>());
    SiblingsGroup alawy = new SiblingsGroup("Alawy", new ArrayList<>());

    public Data(){//setiap mengakses class data, seluruh objek data (student dan sibling-group) baru di add.
        alawy.addNewFamily(hasan);
        alawy.addNewFamily(ihsan);
        alawy.addNewFamily(jafar);

        yahya.addNewFamily(ahmad);
        yahya.addNewFamily(noor);

        nouman.addNewFamily(yazed);

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
        System.out.println("Add into listed family-group? Y/N");
        char select = input.next().charAt(0);
        switch (select) {
            case 'Y':
            int ind = 1;
            System.out.println("Select the number of family-group:");
            for(SiblingsGroup sg : allGroup){
                System.out.println(ind + ". " + sg.getFamilyName());
                ind++;
            }
            System.out.print("Your input goes here -> ");
            int indexFamily = input.nextInt();
            input.nextLine();
            allGroup.get(indexFamily-1).addNewFamily(newStudent);
            break;
            case 'N':
            SiblingsGroup newSGroup = new SiblingsGroup(family, new ArrayList<>());
            newSGroup.addNewFamily(newStudent);
            allGroup.add(newSGroup);
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
        int indexsg = 0, keysg = -1, keys = 0;
        for (SiblingsGroup sg : allGroup){//cari index anaknya di list
            int indexs = 0;
            for (Student s : sg.getFamilyList()) {
                if (s.getName().equalsIgnoreCase(studentsName)) {
                    keys = indexs;
                    keysg = indexsg;
                    break;
                }
                indexs++;
            }
            indexsg++;
        }

        if (allGroup.get(keysg).getVisitCount() < 2) {
            allGroup.get(keysg).getFamilyList().get(keys).visit();
            allGroup.get(keysg).visit();
            System.out.println(allGroup.get(keysg).getFamilyName() + "'s family visit: " + allGroup.get(keysg).getVisitCount());
            System.out.println("Times visited for "+allGroup.get(keysg).getFamilyList().get(keys).getName() + " is: " + allGroup.get(keysg).getFamilyList().get(keys).getVisitCount());
        } else System.out.println("Your visit has approach limit");
    }

    public void delete(){
        System.out.print("Please input the student name: ");
        String name = input.nextLine();
        System.out.print("Please input " + name + "'s family name: ");
        String familyName = input.nextLine();

        int indexsg = 0, keysg = 0, keys = 0, indAllS = 0, keyAllS = 0;
        for (SiblingsGroup sg : allGroup){
            int indexs = 0;
            for (Student s : sg.getFamilyList()) {
                if (s.getName().equalsIgnoreCase(name)) {
                    keys = indexs;
                    keysg = indexsg;
                    break;
                }
                indexs++;
            }
            indexsg++;
        }

        for(Student s : allstudents){
            if (name.equalsIgnoreCase(s.getName()) && familyName.equalsIgnoreCase(s.getFamilyName())) {
                keyAllS = indAllS;
            }
            indAllS++;
        }

        System.out.println("Are you sure wanna delete " + name + " Bin " + familyName + "? Y/N");
        char select = input.next().charAt(0);
        input.nextLine();
        switch (select) {
            case 'Y':
            System.out.println("Deleting " + name + " from database.");
            allGroup.get(keysg).getFamilyList().remove(keys);
            allstudents.remove(keyAllS);

            if (allGroup.get(keysg).getFamilyList().isEmpty()) {
                allGroup.remove(keysg);
            }
            break;
            case 'N':
            System.out.println("Cancelling delete.");
            break;
            default:
            System.out.println("Invalid input!");
            break;
        }
    }
}