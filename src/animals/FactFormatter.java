package animals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactFormatter {

    private final Matcher matcher;
    private final boolean canFind;

    public FactFormatter(String fact) {
        Pattern pattern = Pattern.compile("(It)\\s+(can|has|is)\\s+([^.]+)", Pattern.CASE_INSENSITIVE);
        this.matcher = pattern.matcher(fact);
        canFind = this.matcher.find();
    }

    public String format(String subject, boolean isFact) {
        if (!canFind) {
            return "";
        }
        return switch (matcher.group(2).toLowerCase()) {
            case "can" -> String.format("%s %s %s.", subject, isFact ? "can" : "can't", matcher.group(3));
            case "has" -> String.format("%s %s %s.", subject, isFact ? "has" : "doesn't have", matcher.group(3));
            case "is" -> String.format("%s %s %s.", subject, isFact ? "is" : "isn't", matcher.group(3));
            default -> "";
        };
    }

    public String getQuestion() {
        if (!canFind) {
            return "";
        }
        return switch (matcher.group(2).toLowerCase()) {
            case "can" -> String.format("Can it %s?", matcher.group(3));
            case "has" -> String.format("Does it have %s?", matcher.group(3));
            case "is" -> String.format("Is it %s?", matcher.group(3));
            default -> "";
        };
    }
}
