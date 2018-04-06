import cages.*;
import animal.*;
import java.util.Scanner;

public class Javari{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Animal[][] animals = new Animal[5][];
        String[] animalTypes= new String[] {"cat", "lion", "eagle", "parrot", "hamster"};
        int count;

        System.out.println("Welcome to Javari Park!");
        System.out.println("Input the number of animals");
        
        for(int i=0; i < animalTypes.length; i++){
            System.out.printf("%s: ", animalTypes[i]);
            count = Integer.parseInt(input.nextLine());
            if (count > 0){
                System.out.printf("Provide the information of %s(s):\n", animalTypes[i]);
                String[] row = new String[count];
                row = input.nextLine().split(",");
                if (row.length != count){
                    System.out.println("incorrect info");
                    System.exit(0);
                }
                Animal[] temp = new Animal[count];
                for (int j=0; j<count; j++){
                    if(i==0) temp[j] = new Cat(row[j].split("\\|")[0], Integer.parseInt(row[j].split("\\|")[1]));
                    else if(i==1) temp[j] = new Lion(row[j].split("\\|")[0], Integer.parseInt(row[j].split("\\|")[1]));
                    else if(i==2) temp[j] = new Eagle(row[j].split("\\|")[0], Integer.parseInt(row[j].split("\\|")[1]));
                    else if(i==3) temp[j] = new Parrot(row[j].split("\\|")[0], Integer.parseInt(row[j].split("\\|")[1]));
                    else temp[j] = new Hamster(row[j].split("\\|")[0], Integer.parseInt(row[j].split("\\|")[1]));
                }
                animals[i] = temp;
            }
        }

        System.out.print("Animals have been successfully recorded!");
        System.out.println("\n=============================================");
        
        System.out.println("Cage arrangement:");
        for (int i=0; i<animalTypes.length; i++){
            if(animals[i] != null){
                CageArrangement a = new CageArrangement(animals[i]);
                System.out.println("location: "+a.getLocation());
                System.out.println(a.printInfo());
                a.rearrange();
                System.out.println("After rearrangement...");
                System.out.println(a.printInfo());
            }
        }


        System.out.println("NUMBER OF ANIMALS:");
        for(int i=0; i < animals.length; i++){
            if (animals[i] != null) System.out.printf("%s:%d\n", animalTypes[i], animals[i].length);
            else System.out.printf("%s:0\n", animalTypes[i]);
        }
        System.out.println("\n=============================================");
        String in;
        boolean found;
        while(true){
            System.out.println("Which animal you want to visit?");
            System.out.println("(1: Cat, 2: Eagle, 3: Hamster, 4: Parrot, 5: Lion, 99: Exit)");
            in = input.nextLine();
            if (in.equals("1")){
                // interaction with CAT
                System.out.print("Mention the name of cat you want to visit: ");
                in = input.nextLine();
                found = false;
                if (animals[0] != null){
                    for(int i=0; i < animals[0].length; i++){
                        if (animals[0][i].getName().equals(in)){
                            found = true;
                            System.out.printf("You are visiting %s (cat) now, what would you like to do?\n", in);
                            System.out.println("1: Brush the fur 2: Cuddle");
                            in = input.nextLine();
                            if (in.equals("1")){
                                System.out.printf("Time to clean %s's fur\n", animals[0][i].getName());
                                System.out.printf("%s makes a voice: %s\n", animals[0][i].getName(), ((Cat)animals[0][i]).brush());
                            }else if (in.equals("2")){
                                System.out.printf("%s makes a voice: %s\n",animals[0][i].getName(),((Cat)animals[0][i]).cuddle());
                            }
                            break;
                        }
                    }
                }
                if (!found) System.out.print("There is no cat with that name!");
            }
            else if (in.equals("2")){
                // interaction with EAGLE
                System.out.print("Mention the name of eagle you want to visit: ");
                in = input.nextLine();
                found = false;
                if (animals[2] != null){
                    for(int i=0; i < animals[2].length; i++){
                        if (animals[2][i].getName().equals(in)){
                            found = true;
                            System.out.printf("You are visiting %s (eagle) now, what would you like to do?\n", in);
                            System.out.println("1: Order to fly");
                            in = input.nextLine();
                            if (in.equals("1")){
                                System.out.printf("%s makes a voice: %s\n",animals[2][i].getName(),((Eagle)animals[2][i]).fly());
                                System.out.println("You hurt!");
                            }else{
                                System.out.println("You do nothing...");
                            }
                            break;
                        }
                    }
                }
                if (!found) System.out.print("There is no eagle with that name!");
            }
            else if (in.equals("3")){
                // interaction with HAMSTER
                System.out.print("Mention the name of hamster you want to visit: ");
                in = input.nextLine();
                found = false;
                if (animals[4] != null){
                    for(int i=0; i < animals[4].length; i++){
                        if (animals[4][i].getName().equals(in)){
                            found = true;
                            System.out.printf("You are visiting %s (hamster) now, what would you like to do?\n", in);
                            System.out.println("1: See it gnawing 2: Order to run in the hamster wheel");
                            in = input.nextLine();
                            if (in.equals("1")){
                                System.out.printf("%s makes a voice: %s\n",animals[4][i].getName(),((Hamster)animals[4][i]).gnaw());
                            }else if (in.equals("2")){
                                System.out.printf("%s makes a voice: %s\n",animals[4][i].getName(),((Hamster)animals[4][i]).runHamsterWheel());
                            }else{
                                System.out.println("You do nothing...");
                            }
                            break;
                        }
                    }
                }
                if (!found) System.out.print("There is no hamster with that name!");
            }
            else if (in.equals("4")){
                // interaction with PARROT
                System.out.print("Mention the name of parrot you want to visit: ");
                in = input.nextLine();
                found = false;
                if (animals[0] != null){
                    for(int i=0; i < animals[3].length; i++){
                        if (animals[3][i].getName().equals(in)){
                            found = true;
                            System.out.printf("You are visiting %s (parrot) now, what would you like to do?\n", in);
                            System.out.println("1: Order to fly 2: Do conversation");
                            in = input.nextLine();
                            if (in.equals("1")){
                                System.out.printf("%s makes a voice: %s\n",animals[3][i].getName(),((Parrot)animals[3][i]).fly());
                            }else if (in.equals("2")){
                                in = input.nextLine();
                                System.out.printf("%s makes a voice: %s\n",animals[3][i].getName(),((Parrot)animals[3][i]).immitate(in));
                            }else{
                                System.out.printf("%s says: %s\n", animals[3][i].getName(), ((Parrot)animals[3][i]).immitate());
                            }
                            break;
                        }
                    }
                }
                if (!found) System.out.print("There is no parrot with that name!");
            }
            else if (in.equals("5")){
                // interaction with LION
                System.out.print("Mention the name of lion you want to visit: ");
                in = input.nextLine();
                found = false;
                for(int i=0; i < animals[1].length; i++){
                    if (animals[1][i].getName().equals(in)){
                        found = true;
                        System.out.printf("You are visiting %s (lion) now, what would you like to do?\n", in);
                        System.out.println("1: See it hunting 2: Brush the mane 3: Disturb it");
                        in = input.nextLine();
                        if (in.equals("1")){
                            System.out.printf("%s makes a voice: %s\n",animals[1][i].getName(),((Lion)animals[1][i]).hunt());
                        }else if (in.equals("2")){
                            System.out.printf("%s makes a voice: %s\n",animals[1][i].getName(),((Lion)animals[1][i]).brush());
                        }else if (in.equals("3")){
                            System.out.printf("%s makes a voice: %s\n",animals[1][i].getName(),((Lion)animals[1][i]).disturb());
                        }else{
                            System.out.println("You do nothing...");
                        }
                        break;
                    }
                }
                if (!found) System.out.print("There is no lion with that name!");
            }
            else if (in.equals("99")){
                break;
            }
            else{
                System.out.println("invalid input");
            }
            System.out.println("Back to the office!\n");
        }


    }
}