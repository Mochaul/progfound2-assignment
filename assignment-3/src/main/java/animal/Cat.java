package animal;
import java.util.Random;

public class Cat extends Animal{
    Random random = new Random();
    String[] sounds = new String[] {"Miaaaw..", "Purrr..", "Mwaw!", "Mraaawr!"};

    public Cat(int id, String name, boolean gender, double length, double weight, String condition, boolean health){
        super(id, name, gender, length, height, condition, health);
    }
    
    public String brush(){
        return "Nyaaan...";
    }

    public String cuddle(){
        return sounds[random.nextInt(4)];
    }
}