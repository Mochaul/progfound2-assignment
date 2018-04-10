public class Categories{
    ArrayList<Category> sections ;

    public Categories(){
        sections = new ArrayList<>();
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
            arr[i] = this.section.get(i).getSection();
        }
        return arr;
    }

    private boolean containsSection(String section){
        for(int i=0; i < this.sections.size(); i++){
            if (this.sections.get(i).getSections().equals(section)){
                return true;
            }
        }
        return false;
    }

    private int indexOfSection(String section){
        for(int i=0; i < this.sections.size(); i++){
            if (this.sections.get(i).getSection().equals(section)){
                return i;
            }
        }
    }

    
}