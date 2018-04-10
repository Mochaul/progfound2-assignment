package animal;

public class Parrot extends Animal{
    public Parrot(int id, String name, String gender, double length, double height, String condition, String health){
        super(id, name, gender, length, height, condition, health);
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