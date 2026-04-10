import java.util.*;

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
        
        List<Bogie> bogies = new ArrayList<>();
        
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        
        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        
        for (Bogie b : bogies) {
            System.out.println(b.name + " Capacity: " + b.capacity);
        }
    }
}