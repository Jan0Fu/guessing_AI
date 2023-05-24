package animals;

import java.time.LocalTime;

public class Greeting {

    public String say() {

        LocalTime localTime = LocalTime.now();

        if (localTime.isAfter(LocalTime.of(5, 0, 0)) && localTime.isBefore(LocalTime.of(12, 0, 0))) {
            return "Good morning";
        } else if (localTime.isAfter(LocalTime.of(12, 0, 0)) && localTime.isBefore(LocalTime.of(18, 0, 0))) {
            return "Good afternoon";
        } else {
            return "Good evening";
        }
    }
}
