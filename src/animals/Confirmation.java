package animals;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Confirmation {

    public boolean is(String message) {
        System.out.println(message);
        return response();
    }

    private boolean response() {
        String response = new Scanner(System.in).nextLine().trim();

        Pattern patYes = Pattern.compile(
                "(y|yes|yeah|yep|sure|right|affirmative|correct|indeed|you bet|exactly|you said it)[!.]?",
                Pattern.CASE_INSENSITIVE
        );
        Pattern patNo = Pattern.compile(
                "(n|no|no way|nah|nope|negative|I don't think so|yeah no)[!.]?",
                Pattern.CASE_INSENSITIVE
        );

        if (patYes.matcher(response).matches()) {
            return true;
        }
        if (patNo.matcher(response).matches()) {
            return false;
        }
        System.out.println(new Clarification().say());
        return response();
    }

}
