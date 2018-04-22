package javari.animal;

/**
 * This class represents a Snake that inherits Animal
 * 
 * @author Nicolaus
 */
public class Snake extends Animal{

    private boolean isTame;

    /**
     * Constructs an instance of {@code Snake}
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
    public Snake(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isTame = specificCondition.equals("tame") ? true : false;
    }

    public boolean specificCondition(){
        return isTame;
    }
}