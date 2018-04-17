package javari.animal;

/**
 * This class describes bodily features in an animal.
 *
 * @author Programming Foundations 2 Teaching Team
 * @author TODO If you make changes in this class, please write your name here
 *     and describe the changes in the comment block
 */
public class Body {

    private double length;
    private double weight;
    private Gender gender;

    /**
     * Constructs an instance of {@code Body} that part of an {@code Animal}.
     *
     * @param length length of animal in centimeters
     * @param weight weight of animal in kilograms
     * @param gender gender of animal (male/female)
     */
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
