package cages;
import animal.*;

public class Cage {
    String location;
    Animal animal;
    String type;
    int length;
    int width;

    public Cage(){
        this.location = "a";
    }
    
    public Cage(String location, Animal animal, String type, int length, int width){
        this.location = location;
        this.animal = animal;
        this.type = type;
        this.length = length;
        this.width = width;
    }

    public String getLocation(){
        return this.location;
    }
    
    public Animal getAnimal(){
        return this.animal;
    }

    public String getType(){
        return this.type;
    }

    public static Cage determineCage(Animal animal){
        if (animal instanceof Cat || animal instanceof Hamster || animal instanceof Parrot){
            if (animal.getLength() < 45) return new Cage("Indoor", animal, "A", 60, 60);
            else if(animal.getLength() <= 60) return new Cage("Indoor", animal, "B", 60, 90);
            else return new Cage("Indoor", animal, "C", 60, 120);
        }else{
            if (animal.getLength() < 75) return new Cage("Outdoor", animal, "A" , 120, 120);
            else if (animal.getLength() <= 90) return new Cage("Outdoor", animal, "B", 120, 150);
            else return new Cage("Outdoor", animal, "C", 120, 180);
        }
    }
}