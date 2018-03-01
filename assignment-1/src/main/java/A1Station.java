import java.util.Scanner;

public class A1Station {

    private static final double THRESHOLD = 250; // in kilograms

    // You can add new variables or methods in this class

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dataCount = Integer.parseInt(input.nextLine());

        String[] catArgs;
        TrainCar head = null;
        int trainCount = 0;
        double avgMassIndex;
        String category; 

        for(int i=0; i < dataCount; i++){
            catArgs = input.nextLine().split(",");
            WildCat cat = new WildCat(catArgs[0], Double.parseDouble(catArgs[1]), Double.parseDouble(catArgs[2]));

            if (head == null){
                TrainCar train = new TrainCar(cat);
                head = train;
            }else{
                TrainCar train = new TrainCar(cat, head);
                head = train;
            }
            trainCount++;

            if (head.computeTotalWeight() + TrainCar.EMPTY_WEIGHT * trainCount > 250.0 || i == dataCount - 1){
                System.out.println("The train departs to Javari Park");
                System.out.print("[LOCO]<--");
                head.printCar();
                avgMassIndex = head.computeTotalMassIndex()/trainCount;
                trainCount = 0;
                head = null;
                System.out.println("Average mass index of all cats: " +  avgMassIndex);
                if ( avgMassIndex < 18.5 ){
                    category = "underweight";
                }else if(avgMassIndex < 25.0 ){
                    category = "normal";
                }else if(avgMassIndex < 30.0 ){
                    category = "overweight";
                }else{
                    category = "obese";
                }
                System.out.println("In average, the cats in the train are *" + category + "*");   
            }
        } // END For loop
        
        input.close();
    } // END main
}

