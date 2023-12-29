import java.util.ArrayList;
import java.util.List;
public class SiblingsGroup {
    private String familyName;
    private List<Student> familyList;
    private int visitCount = 0;
    public SiblingsGroup(String familyName, List<Student> siblingsGroup){
        this.familyName = familyName;
        familyList = siblingsGroup;
    }

    public String getFamilyName(){
        return familyName;
    }

    public List<Student> getFamilyList(){
        List<Student> list2 = new ArrayList<>();
        for (Student student : familyList) {
            list2.add(student);
        }
        return list2;
    }

    public void addNewFamily(Student s){
        familyList.add(s);
    }
    
    public void visit(){
        for (Student student : familyList) {
            visitCount += student.getVisitCount();
        }
    }

    public int getVisitCount(){
        return visitCount;
    }
}
