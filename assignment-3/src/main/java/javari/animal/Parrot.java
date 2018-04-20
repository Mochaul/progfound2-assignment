package javari.animal;

public class Parrot extends Animal{

    private boolean isLayingEggs;

    public Parrot(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isLayingEggs = specificCondition.equals("laying eggs") ? true : false;
    }

    public boolean specificCondition(){
        return !isLayingEggs;
    }
    
    public String fly(){
        return "TERBAAANG...";
    }
    public String immitate(){
        return "HM?";
    }
    public String immitate(String msg){
        return msg.toUpperCase();
    }
}