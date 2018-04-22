package javari.animal;
import java.util.Random;

/**
 * This class represents a Cat that inherits Animal
 * 
 * @author Nicolaus
 */
public class Cat extends Animal{
    
    private Random random = new Random();
    private String[] sounds = new String[] {"Miaaaw..", "Purrr..", "Mwaw!", "Mraaawr!"};
    private boolean isPregnant;

    /**
     * Constructs an instance of {@code Cat}
     * 
     * @param id        unique identifier
     * @param type      type of animal, e.g. Hamster, Cat, Lion, Parrot
     * @param name      name of animal, e.g. hamtaro, simba
     * @param gender    gender of animal (male/female)
     * @param length    length of animal in centimeters
     * @param weight    weight of animal in kilograms
     * @param condition health condition of the animal
     * @param specificCondition specific condition that determines showability in performances
     */
    public Cat(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isPregnant = specificCondition.equals("pregnant") ? true : false;
    }
    
    public boolean specificCondition(){
        return !isPregnant;
    }

    public String brush(){
        return "Nyaaan...";
    }

    public String cuddle(){
        return sounds[random.nextInt(4)];
    }
}