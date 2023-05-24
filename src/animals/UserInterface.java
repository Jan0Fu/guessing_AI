package animals;


import java.util.Scanner;

public class UserInterface {

    public void start() {

        System.out.println(new Greeting().say());
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first animal:");
        String firstAnimal = scanner.nextLine();
        System.out.println("Enter the second animal:");
        String secondAnimal = scanner.nextLine();

        new AnimalFact(firstAnimal, secondAnimal).prompt();
        System.out.println();

        System.out.println(new Goodbye().say());
    }
}


