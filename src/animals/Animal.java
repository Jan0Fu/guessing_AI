package animals;

public class Animal {

    private final String animal;

    public Animal(String animal) {
        this.animal = animal.toLowerCase().trim();
    }

    public String nameWithArticle() {
        if (animal.matches("(an?|the)\\s.+")) {
            return animal;
        }
        return animal.matches("^[aiueo].+") ? "an " + animal : "a " + animal;
    }

    public String nameWithoutArticle() {
        return animal.replaceFirst("(an?|the)\\s+", "");
    }
}
