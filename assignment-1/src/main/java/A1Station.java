import java.util.Scanner;

public class A1Station {

    private static final double THRESHOLD = 250; // in kilograms

    // You can add new variables or methods in this class

    public static void main(String[] args) {
        // TODO Complete me!

        // testing
        WildCat cat1 = new WildCat("Garfield", 10.0, 5.0);
        WildCat cat2 = new WildCat("PUPU", 15.0, 20.0);

        TrainCar train1 = new TrainCar(cat1);
        TrainCar train2 = new TrainCar(cat2, train1);

        TrainCar head = train2;

        System.out.println("weight");
        System.out.println(cat1.weight);
        System.out.println(cat2.weight);
        System.out.println(head.computeTotalWeight());

        System.out.println("bmi");
        System.out.println(cat1.computeMassIndex());
        System.out.println(cat2.computeMassIndex());
        System.out.println(head.computeTotalMassIndex());

        System.out.println("printing cats");
        head.printCar();
        // testing END

    }
}
