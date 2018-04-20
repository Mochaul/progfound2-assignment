package javari.animal;

public class Hamster extends Animal{
    
    private boolean isPregnant;

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