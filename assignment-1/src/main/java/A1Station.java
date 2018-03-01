import java.util.Scanner;

public class A1Station {

    private static final double THRESHOLD = 250; // in kilograms

    // You can add new variables or methods in this class

    public static void main(String[] args) {
        // initialize scanner
        Scanner input = new Scanner(System.in);

        // declare variables
        String[] catArgs;           // array to hold 3 args for WildCat constructor
        TrainCar head = null;       // points to head of linked list
        int trainCount = 0;         // tracks number of TrainCar in linked list
        double avgMassIndex;
        String category;
        String data; 

        // number of user input line
        int dataCount = Integer.parseInt(input.nextLine());

        for(int i=0; i < dataCount; i++){
            data = input.nextLine().replaceAll("\\s+",""); // removes whitespace in user input
            catArgs = data.split(",");
            WildCat cat = new WildCat(catArgs[0], Double.parseDouble(catArgs[1]), Double.parseDouble(catArgs[2])); // make new instance of WildCat

            if (head == null){
                TrainCar train = new TrainCar(cat); // if empty, then train is the end of linked list
                head = train;
            }else{
                TrainCar train = new TrainCar(cat, head); // points to next train in linked list
                head = train;
            }
            trainCount++; // increment number of train in linked list

            // if total weight of cat and train exceed THRESHOLD or if last cat, depart train
            if (head.computeTotalWeight() + TrainCar.EMPTY_WEIGHT * trainCount > THRESHOLD || i == dataCount - 1){
                System.out.println("The train departs to Javari Park");
                System.out.print("[LOCO]<--");
                head.printCar();

                avgMassIndex = head.computeTotalMassIndex()/trainCount;
                head = null;        // reset head pointer
                trainCount = 0;     // reset number of train in linked list

                // prints info of avg mass index of cat and category
                System.out.printf("Average mass index of all cats: %.2f\n", avgMassIndex);
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

