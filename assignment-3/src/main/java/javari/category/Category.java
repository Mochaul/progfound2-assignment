package javari.category;

import java.util.ArrayList;

public class Category{
    String name;
    String category;
    ArrayList<String> types;

    public Category(String name, String category){
        this.name = name;
        this.category = category;
        this.types = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }

    public ArrayList<String> getTypes(){
        return this.types;
    }
    
    public void addType(String type){
        this.types.add(type);
    }



}