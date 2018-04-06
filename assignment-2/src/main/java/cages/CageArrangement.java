package cages;
import animal.*;
import java.util.ArrayList;

public class CageArrangement{
    ArrayList[] content = new ArrayList[3];
    String location = "";

    public CageArrangement(Animal[] animals){
        if (animals.length > 0) this.location = Cage.determineCage(animals[0]).getLocation();
        for (int a=0; a<3; a++) this.content[a] = new ArrayList<Cage>();
        for(int i=0; i < animals.length; i++){
            if (animals.length >= 3){
                if (i < animals.length/3){
                    this.content[2].add(Cage.determineCage(animals[i]));
                }else if (i < 2*animals.length/3){
                    this.content[1].add(Cage.determineCage(animals[i]));
                }else{
                    this.content[0].add(Cage.determineCage(animals[i]));
                }
            }else{
                for(int j = 0; j<animals.length; j++){
                    this.content[2-j].add(Cage.determineCage(animals[j]));
                }
            }
        }
    }

    public String getLocation(){
        return this.location;
    }

    public String printInfo(){
        String result = "";
        Cage c;
        for(int i=0; i < content.length; i++){
            result += "Level " + (3 - i) + ": ";
            for(int j=0; j < content[i].size(); j++){
                c = (Cage)content[i].get(j);
                result += String.format("%s (%d - %s), ", c.getAnimal().getName(), c.getAnimal().getLength(), c.getType());
            }
            result += "\n";
        }
        return result;
    }

    public void rearrange(){
        ArrayList temp = new ArrayList<Cage>();
        for(int i=0; i < 2; i++){
            temp = this.content[(i)%this.content.length];
            this.content[i] = this.content[(i+1)%this.content.length];
            this.content[(i+1)%this.content.length] = temp;
        }
    }

}