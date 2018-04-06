package animal;

public class Parrot extends Animal{
    public Parrot(String name, int length){
        super(name, length);
        this.type = "Parrot";
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