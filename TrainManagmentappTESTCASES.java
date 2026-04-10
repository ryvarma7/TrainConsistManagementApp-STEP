import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainManagmentappTESTCASES {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 24)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Luxury", 90),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 24)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Luxury", 90)
        );

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, bogies.size());
    }
}