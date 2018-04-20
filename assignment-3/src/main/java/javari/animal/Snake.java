package javari.animal;

public class Snake extends Animal{

    private boolean isTame;

    public Snake(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isTame = specificCondition.equals("tame") ? true : false;
    }

    public boolean specificCondition(){
        return isTame;
    }
}