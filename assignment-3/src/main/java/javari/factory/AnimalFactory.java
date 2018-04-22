package javari.factory;
import java.util.ArrayList;
import javari.animal.*;

public class AnimalFactory{

    private ArrayList<Animal> animals;

    public AnimalFactory(){
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals(){
        return this.animals;
    }

    // design change: validate and process input in CSVReader
    // change argument type to be appropriate for animal constructor
    public void addAnimals(String[] rowsOfInput){
        String[] row;
        for (int i=0; i<rowsOfInput.length; i++){
            //Animal(Integer id, String type, String name, Gender gender, double length,
            //  double weight, Condition condition)
            //1,Hamster,hamtaro,male,5,0.25,,healthy
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
                    default:
                        System.out.println("reached default");
                        break;
                }
            } catch (Exception e){
                System.out.println("exception");
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