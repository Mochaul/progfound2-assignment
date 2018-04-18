package animal;
import java.util.ArrayList;

public class AnimalFactory{
    ArrayList<Animal> animals;
    int invalid;

    public AnimalFactory(){
        animals = new ArrayList<>();
        this.invalid = 0;
    }

    public void addAnimal(String[] arr){
        if (arr.length != 8){
            System.out.println("invalid number of arguments for craeting Animal");
            this.invalid += 1;
            return;
        }
        boolean h, g;
        boolean canPerform = true;
        if (arr[6].equals("healthy")) h = true;
        else h = false; 
        if (arr[2].equals("male")) g = true;
        else g = false;

        // TODO add canPeform method
        if (arr[1].equals("Hamster")){
            if (arr[6].equals("pregnant")) canPerform =  false;
            this.animals.add(new Hamster(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));
        }else if (arr[1].equals("Lion")){
            if (arr[6].equals("pregnant") || arr[4].equals("female")) canPerform =  false;
            this.animals.add(new Lion(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));

        }else if (arr[1].equals("Cat")){
            if (arr[6].equals("pregnant")) canPerform =  false;
            this.animals.add(new Cat(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));

        }else if (arr[1].equals("Whale")){
            if (arr[6].equals("pregnant")) canPerform =  false;
            this.animals.add(new Whale(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));
            
        }else if (arr[1].equals("Eagle")){
            if (arr[6].equals("laying eggs")) canPerform =  false;
            this.animals.add(new Eagle(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));
            
        }else if (arr[1].equals("Parrot")){
            if (arr[6].equals("laying eggs")) canPerform =  false;
            this.animals.add(new Parrot(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));
            
        }else if (arr[1].equals("Snake")){
            if (!arr[6].equals("tame")) canPerform =  false;
            this.animals.add(new Snake(Integer.parseInt(arr[0]), arr[2], g, Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), arr[6], h, canPerform));
            
        }
    }

    public String toString(){
        String result = "";
        for (int i=0; i<this.animals.size(); i++){
            result += this.animals.get(i) + "\n";
        }
        return result;
    }
}