import java.util.ArrayList;
// use arrlist.contains(obj) for checking elem
public class Category{
    String section;
    String category;
    ArrayList<String> types = new ArrayList<>();
    // static ArrayList<String> sections =  new ArrayList<>();

    public Category(String type, String category, String section){
        this.type.add(type);
        this.category = category;
        this.section = section;
        sections.add(section);
    }
    
    public void addType(String type){
        this.type.add(type);
    }
    public String[] getType(){
        return this.type.toArray(new String[this.type.size()]);
    }
    public String getCategory(){
        return this.category;
    }
    public String getSection(){
        return this.section;
    }
}