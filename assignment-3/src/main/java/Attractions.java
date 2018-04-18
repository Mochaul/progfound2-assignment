import java.util.ArrayList;

public class Attractions{
    ArrayList<Attraction> attractions;
    int invalid;

    public Attractions(){
        attractions = new ArrayList<>();
        this.invalid = 0;
    }

    public void addAttraction(String type, String attractionName, Categories categories){
        int index = this.indexOfAttraction(attractionName);
        if (categories.haveType(type)){
            if (index == -1){
                this.attractions.add(new Attraction(attractionName));
                this.attractions.get(this.attractions.size()-1).addType(type);
            }else{
                this.attractions.get(index).addType(type);
            }
        }
        else{
            this.invalid += 1;
            System.out.println(type + " invalid");
        }
    }

    public boolean containsAttraction(String attraction){
        for (int i=0; i<this.attractions.size(); i++){
            if(this.attractions.get(i).getName().equals(attraction)){
                return true;
            }
        }
        return false;

    }

    public int indexOfAttraction(String attraction){
        for (int i=0; i<this.attractions.size(); i++){
            if(this.attractions.get(i).getName().equals(attraction)){
                return i;
            }
        }
        return -1;
    }

    public String printAttractions(){
        String result = "";
        for (int i=0; i<this.attractions.size(); i++){
            result += this.attractions.get(i).getName() + "\n";
            for (int j=0; j<this.attractions.get(i).getTypes().size(); j++){
                result += this.attractions.get(i).getTypes().get(j) + ", ";
            }
            result += "\n";
        }
        return result;
    }
}