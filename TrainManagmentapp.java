import java.util.*;

public class TrainManagmentappUC1toUC8 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");
        
        System.out.println("Train Formation: " + formation);
    }
}