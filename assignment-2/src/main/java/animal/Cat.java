package animal;
import java.util.Random;

public class Cat extends Animal{
    Random random = new Random();
    String[] sounds = new String[] {"Miaaaw..", "Purrr..", "Mwaw!", "Mraaawr!"};

    public Cat(String name, int length){
        super(name, length);
        this.type = "Cat";
    }

    public String brush(){
        return "Nyaaan...";
    }

    public String cuddle(){
        return sounds[random.nextInt(4)];
    }
}