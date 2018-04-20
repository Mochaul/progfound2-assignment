package javari.animal;

public class Eagle extends Animal{
    
    private boolean isLayingEggs;

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