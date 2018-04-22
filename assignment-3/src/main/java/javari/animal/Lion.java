package javari.animal;

/**
 * This class represents a Lion that inherits Animal
 * 
 * @author Nicolaus
 */
public class Lion extends Animal{

    private boolean isPregnant;

    /**
     * Constructs an instance of {@code Lion}
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
    public Lion(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isPregnant = specificCondition.equals("pregnant") ? true : false;
    }

    public boolean specificCondition(){
        return !isPregnant && this.getGender().equals(Gender.MALE);
    }

    public String hunt(){
        return "Err....";
    }

    public String brush(){
        return "Hauhhmm!";
    }

    public String disturb(){
        return "HAUHHMM!";
    }

}