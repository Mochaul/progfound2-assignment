package javari.animal;

public class Whale extends Animal{

    private boolean isPregnant;

    public Whale(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isPregnant = specificCondition.equals("pregnant") ? true : false;
    }

    public boolean specificCondition(){
        return !isPregnant;
    }
}