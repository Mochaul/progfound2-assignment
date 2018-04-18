package animal;

public class Eagle extends Animal{

    public Eagle(int id, String name, boolean gender, double length, double weight, String condition, boolean health, boolean canPerform){
        super(id, name, gender, length, height, condition, health, canPerform);
    }

    public String fly(){
        return "Kwaakk....";
    }
}