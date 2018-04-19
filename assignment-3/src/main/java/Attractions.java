import animal.*;
import java.util.ArrayList;

public class Attractions{
    ArrayList<Attraction> attractions;
    int invalid;

    public Attractions(){
        attractions = new ArrayList<>();
        this.invalid = 0;
    }

    public ArrayList<Attraction> getAttractions(){
        return this.attractions;
    }

    public int getInvalid(){
        return this.invalid;
    }
    
    public void addAttraction(String type, String attractionName, Categories categories){
        int index = this.indexOfAttraction(attractionName);
        if (categories.haveType(type)){
            if (index == -1){
                this.attractions.add(new Attraction(attractionName));
                this.attractions.get(this.attractions.size()-1).addType(type);
            }else{
                this.attractions.get(index).addType(type);
            }
        }
        else{
            this.invalid += 1;
            System.out.println(type + " invalid");
        }
    }

    public boolean containsAttraction(String attraction){
        for (int i=0; i<this.attractions.size(); i++){
            if(this.attractions.get(i).getName().equals(attraction)){
                return true;
            }
        }
        return false;

    }

    public int indexOfAttraction(String attraction){
        for (int i=0; i<this.attractions.size(); i++){
            if(this.attractions.get(i).getName().equals(attraction)){
                return i;
            }
        }
        return -1;
    }

    public void addAnimalForAttractions(Animal[] animals){
        for (int i=0; i<this.attractions.size(); i++){
            for (int j=0; j<animals.length; j++){
                if (this.attractions.get(i).haveType(animals[j].getType()) && animals[j].canPerform()){
                    this.attractions.get(i).addAnimal(animals[j]);
                }
            }
        }
    }

    public String printAttractions(){
        String result = "";
        for (int i=0; i<this.attractions.size(); i++){
            result += this.attractions.get(i).getName() + "\n";
            for (int j=0; j<this.attractions.get(i).getTypes().size(); j++){
                result += this.attractions.get(i).getTypes().get(j) + ", ";
            }
            result += "\n animals: ";
            for (int k=0; k<this.attractions.get(i).getAnimals().size(); k++){
                result += this.attractions.get(i).getAnimals().get(k).getName() + ", ";
            }
            result += "\n";
        }
        return result;
    }
}