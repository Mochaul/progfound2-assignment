import java.util.ArrayList;

public class Categories{
    ArrayList<Category> sections;
    int invalid = 0;

    public Categories(){
        this.sections = new ArrayList<>();
        this.invalid = 0;
    }
    
    public ArrayList<Category> getSections(){
        return this.sections;
    }

    public void addCategory(String type, String category, String section){
        int index = this.indexOfSection(section);
        if (index != -1){
            this.sections.get(index).addType(type);
        }else{
            this.sections.add(new Category(category, section));
            this.sections.get(this.sections.size() - 1).addType(type);
        }
    }

    public boolean containType(String type){
        for(int i=0; i<this.sections.size(); i++){
            for(int j=0; j<this.sections.get(i).getTypesAsArrayList().size(); j++){
                if (this.sections.get(i).getTypesAsArrayList().get(j).equals(type)){
                    return true;
                }
            }
        }
        return false;
    }

    public String[] toArrayOfString(){
        String[] arr = new String[this.sections.size()];
        for(int i=0; i<this.sections.size(); i++){
            arr[i] = this.sections.get(i).getSection();
        }
        return arr;
    }

    private int indexOfSection(String section){
        for(int i=0; i < this.sections.size(); i++){
            if (this.sections.get(i).getSection().equals(section)){
                return i;
            }
        }
        return -1;
    }

    public String getCategoryOf(String animal){
        for (int i=0; i<this.sections.size(); i++){
            for (int j=0; j<this.sections.get(i).getTypesAsArrayList().size(); j++){
                if (this.sections.get(i).getTypesAsArrayList().get(j).equals(animal)){
                    return this.sections.get(i).getCategory();
                }
            }
        }
        return null;
    } 

    public boolean haveType(String animal){
        for (int i=0; i<this.sections.size(); i++){
            for (int j=0; j<this.sections.get(i).getTypesAsArrayList().size(); j++){
                if (this.sections.get(i).getTypesAsArrayList().get(j).equals(animal)){
                    return true;
                }
            }
        }
        return false;
    }

    public String printCategories(){
        String result = "";
        for (int i=0; i<this.sections.size(); i++){
            result += this.sections.get(i).getSection() + ", " + this.sections.get(i).getCategory() + "\n";
            for (int j=0; j<this.sections.get(i).getTypesAsArrayList().size(); j++){
                result += "\t-" + this.sections.get(i).getTypesAsArrayList().get(j) + "\n";
            }
        }
        return result;
    }
}