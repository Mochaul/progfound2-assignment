public class Categories{
    ArrayList<Category> sections = new ArrayList<>();

    public Categories(String type, String category, String section){
        this.type = type;
        this.category = category;
        this.section = section;
    }
    
    public ArrayList<Category> getSections(){
        return this.sections;
    }

    public void addCategory(String type, String category, String section){
        if (this.containsSection(section)){
            this.sections.get(this.indexOfSection(section)).addType(type);
        }else{
            this.sections.add(new Category(type, category, section));
        }
    }

    public boolean containsSection(String section){
        for(int i=0; i < this.sections.size(); i++){
            if (this.sections.get(i).getSections().equals(section)){
                return true;
            }
        }
        return false;
    }

    public int indexOfSection(String section){
        for(int i=0; i < this.sections.size(); i++){
            if (this.sections.get(i).getSection().equals(section)){
                return i;
            }
        }
    }
    // public boolean containsCategory(String category){
    //     for(int i=0; i < this.sections.size(); i++){
    //         if (this.sections.get(i).getCategory().equals(category)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    
}