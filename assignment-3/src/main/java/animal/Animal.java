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
    
    // public static Animal create(String[] arr){
    //     boolean h, g;
    //     if (arr[6].equals("healthy")) h = true;
    //     else h = false; 
    //     if (arr[2].equals("male")) g = true;
    //     else g = false;
    //     return new Animal(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h);
    // }

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

    abstract boolean isReadyToPerform();
    }
}