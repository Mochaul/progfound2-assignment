package animal;

public class Whale extends Animal{
    public Whale(int id, String name, boolean gender, double length, double weight, String condition, boolean health, boolean canPerform){
        super(id, name, gender, length, weight, condition, health, canPerform);
        this.type = "Whale";
    }
}