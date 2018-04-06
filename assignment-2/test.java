import animal.Animal;
import cage.Cage;

public class test{
    public static void main(String[] args) {
        Animal a = new Animal("a",21);
        System.out.println(a.getName());
        
        Cage cage =  new Cage.determineCage(a);
        System.out.println(cage.getLength());

    }
}