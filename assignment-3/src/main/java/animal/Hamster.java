package animal;

public class Hamster extends Animal{
    
    public Hamster(int id, String name, boolean gender, double length, double weight, String condition, boolean health){
        super(id, name, gender, length, height, condition, health);
    }

    public String gnaw(){
        return "Ngkkrit.. Ngkkrrriiit";
    }

    public String runHamsterWheel(){
        return "Trrr... Trrr...";
    }
}