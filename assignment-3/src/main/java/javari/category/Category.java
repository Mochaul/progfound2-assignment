package javari.category;

import java.util.ArrayList;

/**
 * This class represents a category in Javari Park
 * 
 * @author Nicolaus
 */
public class Category{

    String name;
    String category;
    ArrayList<String> types;

    /**
     * Constructs an instance of {@code Category}
     * 
     * @param name      name of category e.g. Explore the Mammal
     * @param category  category of animal e.g. Mammal
     */
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
    
    /**
     * Adds new type (e.g. Cat, Parrot) to category
     * 
     * @return
     */
    public void addType(String type){
        this.types.add(type);
    }



}