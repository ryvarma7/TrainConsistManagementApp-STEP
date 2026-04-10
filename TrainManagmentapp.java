import java.util.*;
import java.util.stream.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class TrainManagmentapp {
    public static void main(String[] args) {
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 65));

        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.getName()));

        grouped.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
}