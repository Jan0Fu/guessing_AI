package animals;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {

    Scanner scan = new Scanner(System.in);
    Random random = new Random();

    public void start() {
        greeting();
        System.out.println("Enter an animal:");
        String input = scan.nextLine().toLowerCase().strip();
        String animal;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o');

        if (input.startsWith("a ") || input.startsWith("an ")) {
            animal = input;
        } else if (input.startsWith("the ")) {
            input = input.substring(4);
            animal = vowels.contains(input.charAt(0)) ? "an " + input : "a " + input;
        } else {
            animal = vowels.contains(input.charAt(0)) ? "an " + input : "a " + input;
        }

        verify(animal);
        System.out.println(Lingo.bye.get(random.nextInt(Lingo.bye.size())));
    }

    private void greeting() {
        LocalTime now = LocalTime.now();
        if (now.isAfter(LocalTime.of(5, 0)) && now.isBefore(LocalTime.of(12, 0))) {
            System.out.println("Good morning!\n");
        } else if (now.isAfter(LocalTime.of(18, 0)) && now.isBefore(LocalTime.of(5, 0))) {
            System.out.println("Good evening!\n");
        } else {
            System.out.println("Good afternoon!\n");
        }
    }

    private void verify(String animal) {
        System.out.println("Is it " + animal + "?");
        while (true) {
            String input = scan.nextLine().toLowerCase().strip();
            if (input.endsWith(".") || input.endsWith("!")) input = input.substring(0, input.length() - 1);
            if (Lingo.agree.contains(input)) {
                System.out.println("You answered: Yes\n");
                break;
            } else if (Lingo.disagree.contains(input)) {
                System.out.println("You answered: No\n");
                break;
            } else {
                System.out.println(Lingo.clarify.get(random.nextInt(Lingo.clarify.size())));
            }
        }
    }
}
