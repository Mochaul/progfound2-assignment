package javari.attraction;

import java.util.List;
import java.util.ArrayList;

import javari.park.SelectedAttraction;
import javari.animal.*;

public class Attraction implements SelectedAttraction{
    String name;
    String type;
    List<Animal> performers;

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
        this.performers.add(performer);
        return true;    
    }
}