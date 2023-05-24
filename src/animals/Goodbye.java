package animals;

import java.util.Random;

public class Goodbye {

    private final String[] phrases = {
            "Have a nice day!",
            "See you soon!",
            "Bye!",
            "Thank you and Goodbye!",
            "Talk to you later!",
            "See you later!",
            "See you!"
    };

    public String say() {
        return phrases[new Random().nextInt(phrases.length)];
    }
}
