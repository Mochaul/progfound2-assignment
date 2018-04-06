package animal;
import cages.*;

public class Animal{
    String name;
    String type;
    int length;

    public Animal(String name, int length){
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getLength(){
        return this.length;
    }
}