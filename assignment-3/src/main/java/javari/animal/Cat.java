package javari.animal;
import java.util.Random;

public class Cat extends Animal{
    
    private Random random = new Random();
    private String[] sounds = new String[] {"Miaaaw..", "Purrr..", "Mwaw!", "Mraaawr!"};
    private boolean isPregnant;

    public Cat(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isPregnant = specificCondition.equals("pregnant") ? true : false;
    }
    
    public boolean specificCondition(){
        return !isPregnant;
    }

    public String brush(){
        return "Nyaaan...";
    }

    public String cuddle(){
        return sounds[random.nextInt(4)];
    }
}