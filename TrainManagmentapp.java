import java.util.*;

public class TrainManagmentapp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        List<String> passengerBogies = new ArrayList<>();
        
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        
        System.out.println("After adding bogies: " + passengerBogies);
        
        passengerBogies.remove("AC Chair");
        
        System.out.println("After removing AC Chair: " + passengerBogies);
        
        boolean exists = passengerBogies.contains("Sleeper");
        
        System.out.println("Does Sleeper exist? " + exists);
        
        System.out.println("Final bogie list: " + passengerBogies);
import java.util.stream.*;

class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
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
        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.getType().equals("Cylindrical") || b.getCargo().equals("Petroleum"));

        if (isSafe) {
            System.out.println("Train is Safety Compliant");
        } else {
            System.out.println("Train is NOT Safety Compliant");
        }
        System.out.println("=== Train Consist Management App ===");
        
        Set<String> bogieIds = new HashSet<>();
        
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        bogieIds.add("BG103");
        bogieIds.add("BG102");
        
        System.out.println("Unique Bogie IDs: " + bogieIds);
        LinkedList<String> consist = new LinkedList<>();
        
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");
        
        consist.add(2, "Pantry Car");
        
        consist.removeFirst();
        consist.removeLast();
        
        System.out.println("Final Train Consist: " + consist);
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");
        
        System.out.println("Train Formation: " + formation);
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