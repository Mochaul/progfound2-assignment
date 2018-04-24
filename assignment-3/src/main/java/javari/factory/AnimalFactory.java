package javari.factory;
import java.util.ArrayList;
import javari.animal.*;

/**
 * This class helps to load information about animals into the system
 * 
 * @author Nicolaus
 */
public class AnimalFactory{

    private ArrayList<Animal> animals;

    /**
     * constructs an instance of {@code AnimalFactory}.
     */
    public AnimalFactory(){
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals(){
        return this.animals;
    }
    
    /**
     * adds animal to instance variable from an array of animal information
     * 
     * @return 
     */
    public void addAnimals(String[] rowsOfInput){
        String[] row;
        for (int i=0; i<rowsOfInput.length; i++){
            row = rowsOfInput[i].split(",");
            try{
                switch (row[1]){
                    case "Cat":
                        this.animals.add(new Cat(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                    case "Eagle":
                        this.animals.add(new Eagle(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                    case "Hamster":
                        this.animals.add(new Hamster(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                    case "Lion":
                        this.animals.add(new Lion(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                    case "Parrot":
                        this.animals.add(new Parrot(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                    case "Snake":
                        this.animals.add(new Snake(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                    case "Whale":
                        this.animals.add(new Whale(Integer.parseInt(row[0]), row[1], row[2], Gender.parseGender(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]), Condition.parseCondition(row[7]), row[6]));
                        break;
                }
            } catch (Exception e){
                continue;
            }
        }
    }

    public String toString(){
        String result = "";
        Animal temp;
        for (int i=0; i<this.animals.size(); i++){
            temp = this.animals.get(i);
            result += String.format("#%d %s - %s ; showable %s\n", temp.getId(), temp.getName(), temp.getType(), temp.isShowable());
        }
        return result;
    }
}