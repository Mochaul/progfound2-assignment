package javari.attraction;

import java.util.List;
import java.util.ArrayList;

import javari.park.SelectedAttraction;
import javari.animal.*;

/**
 * This class represents an Attraction in Javari Park
 * 
 * @author Nicolaus
 */
public class Attraction implements SelectedAttraction{
    String name;
    String type;
    List<Animal> performers;

    /**
     * Constructs an instance of {@code Attraction}
     * 
     * @param name     name of attraction
     * @param type     type of animals for attraction e.g. Parrot, Eagle
     */
    public Attraction(String name, String type){
        this.name = name;
        this.type = type;
        this.performers = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public List<Animal> getPerformers(){
        return this.performers;
    }

    public boolean addPerformer(Animal performer){
        return this.performers.add(performer);    
    }

    public String printPerformers(){
        String result = "";
        for (int i=0; i<this.performers.size(); i++){
            if (i == this.performers.size() - 1){
                result += String.format("%s", this.performers.get(i).getName());
            }else{
                result += String.format("%s, ", this.performers.get(i).getName());
            }
        }
        return result;
    }
}