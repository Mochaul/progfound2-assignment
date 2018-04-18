import java.util.ArrayList;
// use arrlist.contains(obj) for checking elem
public class Category{
    String section;
    String category;
    ArrayList<String> types;
    // static ArrayList<String> sections =  new ArrayList<>();

    public Category(String category, String section){
        this.types = new ArrayList<>();
        this.category = category;
        this.section = section;
    }
    
    public void addType(String type){
        this.types.add(type);
    }
    public ArrayList<String> getTypesAsArrayList(){
        return this.types;
    }
    public String[] getTypesAsArray(){
        return this.types.toArray(new String[this.types.size()]);
    }
    public String getCategory(){
        return this.category;
    }
    public String getSection(){
        return this.section;
    }
}