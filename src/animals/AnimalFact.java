package animals;

import java.util.Scanner;

public class AnimalFact {

    private final Animal firstAnimal;
    private final Animal secondAnimal;

    public AnimalFact(String firstAnimal, String secondAnimal) {
        this.firstAnimal = new Animal(firstAnimal);
        this.secondAnimal = new Animal(secondAnimal);
    }

    public void prompt() {
        distinguishAnimals(getFact());
    }

    private String getFact() {
        System.out.printf(
                "Specify a fact that distinguishes %s from %s.\n",
                firstAnimal.nameWithArticle(),
                secondAnimal.nameWithArticle()
        );
        System.out.println("The sentence should be of the format: 'It can/has/is ...'.\n");
        String fact = new Scanner(System.in).nextLine();
        if (fact.toLowerCase().matches("^it\\s(can|has|is)\\s.+")) {
            return fact;
        }
        System.out.println("The examples of a statement:");
        System.out.println(" - It can fly");
        System.out.println(" - It has horn");
        System.out.println(" - It is a mammal");
        return getFact();
    }

    private void distinguishAnimals(String fact) {
        FactFormatter formatter = new FactFormatter(fact);
        String confirmation = String.format("Is it correct for %s?", secondAnimal.nameWithArticle());
        boolean isFactSecondAnimal = new Confirmation().is(confirmation);
        System.out.println("I learned the following facts about animals:");
        System.out.printf(" - The %s\n", formatter.format(firstAnimal.nameWithoutArticle(), !isFactSecondAnimal));
        System.out.printf(" - The %s\n", formatter.format(secondAnimal.nameWithoutArticle(), isFactSecondAnimal));
        System.out.println("I can distinguish these animals by asking the question:");
        System.out.printf(" - %s\n", formatter.getQuestion());
    }
}
