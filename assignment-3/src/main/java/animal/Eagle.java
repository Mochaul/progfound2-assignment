package animal;

public class Eagle extends Animal{
    public Eagle(int id, String name, String gender, double length, double height, String condition, String health){
        super(id, name, gender, length, height, condition, health);
    }

    public String fly(){
        return "Kwaakk....";
    }
}