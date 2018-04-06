package animal;

public class Hamster extends Animal{
    
    public Hamster(String name, int length){
        super(name, length);
        this.type = "Hamster";
    }

    public String gnaw(){
        return "Ngkkrit.. Ngkkrrriiit";
    }

    public String runHamsterWheel(){
        return "Trrr... Trrr...";
    }
}