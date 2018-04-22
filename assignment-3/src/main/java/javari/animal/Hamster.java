package javari.animal;

/**
 * This class represents a Hamster that inherits Animal
 * 
 * @author Nicolaus
 */
public class Hamster extends Animal{
    
    private boolean isPregnant;

    /**
     * Constructs an instance of {@code Hamster}
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
    public Hamster(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isPregnant = specificCondition.equals("pregnant") ? true : false;
    }

    public boolean specificCondition(){
        return !isPregnant;
    }

    public String gnaw(){
        return "Ngkkrit.. Ngkkrrriiit";
    }

    public String runHamsterWheel(){
        return "Trrr... Trrr...";
    }
}