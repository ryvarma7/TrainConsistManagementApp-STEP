import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainManagmentappTESTCASES {

    List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 60));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = getSampleBogies();
        int total = list.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum);
        assertEquals(156, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = getSampleBogies();
        list.add(new Bogie("Sleeper", 72));
        int total = list.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum);
        assertEquals(228, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        int total = list.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        int total = list.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = getSampleBogies();
        List<Integer> capacities = list.stream().map(b -> b.getCapacity()).collect(Collectors.toList());
        assertEquals(Arrays.asList(72, 60, 24), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = getSampleBogies();
        int total = list.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum);
        assertTrue(total == 156);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = getSampleBogies();
        int sizeBefore = list.size();
        list.stream().map(b -> b.getCapacity()).reduce(0, Integer::sum);
        assertEquals(sizeBefore, list.size());
    }
}