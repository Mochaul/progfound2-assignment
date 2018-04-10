package animal;

public class Animal{
    int id;
    String name;
    boolean gender;
    double length;
    double weight;
    String condition;
    boolean health;

    public Animal(int id, String name, String gender, double length, double weight, String condition, String health){
        this.id = id;
        this.name = name;
        if (gender.equals("male")) this.gender = true;
        else this.gender = false;
        this.length = length;
        this.weight = weight;
        this.condition = condition;
        if (health.equals("healthy")) this.health = true;
        else this.health = false;
        if (this instanceof Cat || this instanceof Hamster || this instanceof Lion){
            this.category = "mammal";
            this.section = "Explore the Mammals";
        }
        else if (this instanceof Eagle || this instanceof Parrot || this instanceof Whale){
            this.category = "aves";
            this.section = "World of Aves";
        }
        else{
            this.category = "reptiles";
            this.section = "Reptillian Kindom";
        }
    }
    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public boolean getGender(){
        return this.gender;
    }
    public double getLength(){
        return this.length;
    }
    public double getWeight(){
        return this.weight;
    }
    public String getCondition(){
        return this.condition;
    }
    public boolean getHealth(){
        return this.health;
    }
}