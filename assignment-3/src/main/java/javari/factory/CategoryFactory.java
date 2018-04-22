package javari.factory;

import java.util.List;
import java.util.ArrayList;

import javari.category.*;

public class CategoryFactory{
    
    List<Category> categories;

    public CategoryFactory(){
        this.categories = new ArrayList<>(); 
    }

    public void addCategories(String[] rowsOfInput){
        String[] row;
        for (int i=0; i<rowsOfInput.length; i++){
            row = rowsOfInput[i].split(",");
            if (this.indexOfCategory(row[2]) == -1){
                this.categories.add(new Category(row[2], row[1]));
                this.categories.get(this.categories.size() - 1).addType(row[0]);
            }else{
                this.categories.get(this.indexOfCategory(row[2])).addType(row[0]);
            }
        }
    }

    private int indexOfCategory(String name){
        for (int i=0; i<this.categories.size(); i++){
            if (this.categories.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        String result = "";
        for (Category category : categories){
            result += String.format("%s - %s >> ", category.getName(), category.getCategory());
            for (String type : category.getTypes()){
                result += String.format("%s, ", type);
            }
            result += "\n";
        }
        return result;
    }
}