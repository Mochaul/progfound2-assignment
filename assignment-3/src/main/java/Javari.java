import java.util.Scanner;
import animal.*;

public class Javari{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Animal a = Animal.create(input.nextLine().split(","));
        System.out.println(a.getName());
    }
}