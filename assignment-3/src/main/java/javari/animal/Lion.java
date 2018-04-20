package javari.animal;

public class Lion extends Animal{

    private boolean isPregnant;

    public Lion(Integer id, String type, String name, Gender gender, double length,
    double weight, Condition condition, String specificCondition){
        super(id, type, name, gender, length, weight, condition);
        this.isPregnant = specificCondition.equals("pregnant") ? true : false;
    }

    public boolean specificCondition(){
        return !isPregnant && this.getGender().equals(Gender.MALE);
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