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
    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return name + " (" + capacity + ")";
    }
}

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainManagmentappUC1toUC8 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);
        
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " Capacity: " + entry.getValue());
        }
        List<Bogie> bogies = new ArrayList<>();
        
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        
        for (Bogie b : bogies) {
            System.out.println(b.name + " Capacity: " + b.capacity);
        }
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
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}