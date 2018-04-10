package animal;

public class Lion extends Animal{

    public Lion(int id, String name, String gender, double length, double height, String condition, String health){
        super(id, name, gender, length, height, condition, health);
    }

    public String hunt(){
        return "Err....";
    }

    public String brush(){
        return "Hauhhmm!";
    }

    public String disturb(){
        return "HAUHHMM!";
    }

}