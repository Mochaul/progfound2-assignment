import java.util.Scanner;
import animal.*;

public class Javari{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Category a = new Category("Hamster","mammals","Explore the Mammals");
        System.out.println(a.type.get(0));
        a.addType("Lion");
        System.out.println(a.type.get(1));
        String[] b = a.getType();
        for(String c : b){
            System.out.println(c);
        }
    }
}