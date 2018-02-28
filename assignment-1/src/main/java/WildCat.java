public class WildCat {

    // TODO Complete me!
    String name;
    double weight; // In kilograms
    double length; // In centimeters

    public WildCat(String name, double weight, double length) {
        this.name = name;
        this.weight = weight;
        this.length = length;
    }

    public double computeMassIndex() {
        // BMI = weight (kg) / length (m) squared
        double bmi = this.weight / (this.length*this.length);
        return bmi;
    }
}
