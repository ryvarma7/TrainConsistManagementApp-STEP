import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainManagmentappTESTCASES {

    List<Bogie> getBogies(int n) {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Bogie("Sleeper", 50 + (i % 50)));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = getBogies(10);
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = getBogies(10);
        List<Bogie> result = list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = getBogies(100);
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : list) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }
        List<Bogie> streamResult = list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = getBogies(1000);

        long start = System.nanoTime();
        list.stream().filter(b -> b.getCapacity() > 60).collect(Collectors.toList());
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = getBogies(10000);
        List<Bogie> result = list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        assertNotNull(result);
    }
}