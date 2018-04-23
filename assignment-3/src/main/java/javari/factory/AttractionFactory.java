package javari.factory;

import java.util.ArrayList;
import java.util.List;

import javari.animal.Animal;
import javari.attraction.Attraction;


public class AttractionFactory{
    List<Attraction> attractions;

    public AttractionFactory(){
        attractions = new ArrayList<>();
    }

    public List<Attraction> getAttractions(){
        return this.attractions;
    }

    public void addAttractions(String[] rowsOfInput){
        String[] row;
        for (int i=0; i<rowsOfInput.length; i++){
            row = rowsOfInput[i].split(",");
            this.attractions.add(new Attraction(row[1], row[0]));
        }
    }

    public void addPerformers(List<Animal> animals){
        if (animals == null) System.out.println("arg null");
        for (Animal animal : animals){
            if (!animal.isShowable()) continue;
            for (Attraction attraction : this.getAttractionsOfType(animal.getType())){
                attraction.addPerformer(animal);
            }
        }
    }

    public int getAttractionCount(){
        ArrayList<String> names = new ArrayList<>();
        int ctr = 0;
        for (Attraction att : this.attractions){
            if (!names.contains(att.getName())){
                names.add(att.getName());
                ctr++;
            }
        }
        return ctr;

    }

    public ArrayList<Attraction> getAttractionsOfType(String type){
        ArrayList<Attraction> result = new ArrayList<>();
        for (Attraction attraction : this.attractions){
            if (attraction.getType().equals(type)){
                result.add(attraction);
            }
        }
        return result;
    }

    public Attraction getAttractionOf(String name, String type){
        // for (Attraction att : this.getAttractionsOfType(type)){
        //     if (att.getName().equals(name)){
        //         return att;
        //     }
        // }
        // return null;
        for (Attraction att : this.attractions){
            if (att.getName().equals(name) && att.getType().equals(type)){

                return att;
            }
        }
        System.out.println("null");
        return null;
    }

    public String toString(){
        String result = "";
        for (Attraction attraction : this.attractions){
            result += String.format("%s - %s >> ", attraction.getName(), attraction.getType());
            for (Animal animal : attraction.getPerformers()){
                result += String.format("%s, ", animal.getName());
            }
            result += "\n";
        }
        return result;
    }
    
}