package javari.animal;

/**
 * This class represents a Eagle that inherits Animal
 * 
 * @author Nicolaus
 */
public class Eagle extends Animal{
    
    private boolean isLayingEggs;

    /**
     * Constructs an instance of {@code Eagle}
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
    public Eagle(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isLayingEggs = specificCondition.equals("laying eggs") ? true : false;
    }

    public boolean specificCondition(){
        return !isLayingEggs;
    }

    public String fly(){
        return "Kwaakk....";
    }
}