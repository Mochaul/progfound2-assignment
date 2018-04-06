package animal;

public class Lion extends Animal{

    public Lion(String name, int length){
        super(name, length);
        this.type = "Lion";
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