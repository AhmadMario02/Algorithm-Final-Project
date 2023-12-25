public class Student {
    private String name, familyName;
    public Student(String name, String familyName){
        this.name = name;
        this.familyName = familyName;
    }   

    public String getName(){
        return name;
    }

    public String getFamilyName(){
        return familyName;
    }
}