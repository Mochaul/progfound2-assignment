package javari.animal;

public class Body {

    private double length;
    private double weight;
    private Gender gender;

    public Body(double length, double weight, Gender gender) {
        this.length = length;
        this.weight = weight;
        this.gender = gender;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public Gender getGender() {
        return gender;
    }
}
