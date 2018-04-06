package animal;

public class Eagle extends Animal{
    public Eagle(String name, int length){
        super(name, length);
        this.type = "Eagle";
    }

    public String fly(){
        return "Kwaakk....";
    }
}