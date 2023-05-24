package animals;

import java.util.Random;

public class Clarification {

    private final String[] phrases = {
            "Come on, yes or no?",
            "I'm not sure I caught you: was it yes or no?",
            "Funny, I still don't understand, is it yes or no?",
            "Oh, it's too complicated for me: just tell me yes or no.",
            "Could you please simply say yes or no?",
            "Oh, no, don't try to confuse me: say yes or no"
    };

    public String say() {
        return phrases[new Random().nextInt(phrases.length)];
    }
}
