package javari.park;

import java.util.ArrayList;
import java.util.List;

import javari.attraction.Attraction;

public class Visitor implements Registration{
    int id;
    String name;
    List<SelectedAttraction> selectedAttractions;
    private static int idCounter = 1;


    public Visitor(String name){
        this.name = name;
        this.id = idCounter;
        this.selectedAttractions = new ArrayList<>();
        idCounter++;
    }

    public int getRegistrationId(){
        return this.id;
    }

    public String getVisitorName(){
        return this.name;
    }

    public void setVisitorName(String name){
        this.name = name;
    }

    public List<SelectedAttraction> getSelectedAttractions(){
        return this.selectedAttractions;
    }

    public boolean addSelectedAttraction(SelectedAttraction selected){
        return this.selectedAttractions.add(selected);
    }
    
    public void removeLastAttraction(){
        if(this.selectedAttractions.size() > 0){
            this.selectedAttractions.remove(this.selectedAttractions.size() - 1);
        }
    }
}