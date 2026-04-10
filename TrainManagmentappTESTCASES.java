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
        list.add(new Bogie("Sleeper", 72));
        return list;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = getSampleBogies();
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> list = getSampleBogies();
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> list = getSampleBogies();
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("Sleeper", 70));
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertEquals(1, result.keySet().size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> list = getSampleBogies();
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> list = getSampleBogies();
        Map<String, List<Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> list = getSampleBogies();
        int originalSize = list.size();
        list.stream().collect(Collectors.groupingBy(b -> b.getName()));
        assertEquals(originalSize, list.size());
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