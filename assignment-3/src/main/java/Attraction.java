import java.util.ArrayList;
import animal.*;

public class Attraction{
    ArrayList<Animal> animals;
    ArrayList<String> types;
    String name;

    public Attraction(String name){
        this.animals = new ArrayList<>();
        this.types = new ArrayList<>();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public ArrayList<Animal> getAnimals(){
        return this.animals;
    }
    public ArrayList<String> getTypes(){
        return this.types;
    }
    public boolean haveType(String type){
        if (this.types.contains(type)){
            return true;
        }
        return false;
    }
    public void addType(String type){
        this.types.add(type);
    }
}