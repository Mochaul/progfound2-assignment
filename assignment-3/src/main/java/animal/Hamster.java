package animal;

public class Hamster extends Animal{
    
    public Hamster(int id, String name, boolean gender, double length, double weight, String condition, boolean health, boolean canPerform){
        super(id, name, gender, length, weight, condition, health, canPerform);
        this.type = "Hamster";
    }

    public String gnaw(){
        return "Ngkkrit.. Ngkkrrriiit";
    }

    public String runHamsterWheel(){
        return "Trrr... Trrr...";
    }
}