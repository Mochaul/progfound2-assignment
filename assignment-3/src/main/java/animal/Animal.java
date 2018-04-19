package animal;

public class Animal{
    int id;
    String name;
    boolean gender;
    double length;
    double weight;
    String condition;
    boolean health;
    boolean canPerform;
    String type;

    public Animal(int id, String name, boolean gender, double length, double weight, String condition, boolean health, boolean canPerform){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.length = length;
        this.weight = weight;
        this.condition = condition;
        this.health = health;
        this.canPerform = canPerform;
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
    public String getType(){
        return this.type;
    }
    public boolean canPerform(){
        return this.canPerform;
    }
    public String toString(){
        return String.format("#%d; %s; %s; healthy:%s; canperform:%s", this.id, this.type, this.name, this.health, this.canPerform);
    }

}