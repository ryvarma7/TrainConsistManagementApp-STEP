import java.util.*;

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
    }
}