package animal;

public class Parrot extends Animal{
    public Parrot(int id, String name, boolean gender, double length, double weight, String condition, boolean health, boolean canPerform){
        super(id, name, gender, length, height, condition, health, canPerform);
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