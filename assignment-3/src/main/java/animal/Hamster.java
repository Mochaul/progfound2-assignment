package animal;

public class Hamster extends Animal{
    
    public Hamster(int id, String name, String gender, double length, double height, String condition, String health){
        super(id, name, gender, length, height, condition, health);
    }

    public String gnaw(){
        return "Ngkkrit.. Ngkkrrriiit";
    }

    public String runHamsterWheel(){
        return "Trrr... Trrr...";
    }
}