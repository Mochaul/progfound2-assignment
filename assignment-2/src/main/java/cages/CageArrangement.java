package cages;
import animal.*;
import java.util.ArrayList;

public class CageArrangement{
    ArrayList[] content = new ArrayList[3];

    public CageArrangement(Animal[] animals){
        for (int a=0; a<3; a++) this.content[a] = new ArrayList<Cage>();
        for(int i=0; i < animals.length; i++){
            if (i < animals.length/3){
                this.content[2].add(Cage.determineCage(animals[i]));
            }else if (i < 2*animals.length/3){
                this.content[1].add(Cage.determineCage(animals[i]));
            }else{
                this.content[0].add(Cage.determineCage(animals[i]));
            }
        }
    }

    public String printInfo(){
        String result = "";
        Cage c = new Cage();
        for(int i=0; i < content.length; i++){
            result += "Level " + (3 - i) + ": ";
            for(int j=0; j < content[i].size(); j++){
                c = (Cage)content[i].get(j);
                result += String.format("%s (%d - %s), ", c.getAnimal().getName(), c.getAnimal().getLength(), c.getType());
            }
            result += "\n";
        }
        return "Cage arrangement:\nlocation: " + c.getLocation() + "\n" + result;
    }
}