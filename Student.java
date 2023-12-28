public class Student {
    private String name, familyName;
    private int visitCount = 0;
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

    public void visit(){
        visitCount++;
    }

    public int getVisitCount(){
        return visitCount;
    }
}