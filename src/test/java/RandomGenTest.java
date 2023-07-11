import org.junit.jupiter.api.RepeatedTest;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class RandomGenTest {

    private int[] numbers;
    private float[] probabilities;

    @RepeatedTest(10)
    public void test1000() {
        numbers = new int[]{-1, 0, 1, 2, 3};
        probabilities = new float[]{(float) 0.01, (float) 0.3, (float) 0.58, (float) 0.1, (float) 0.01};

        Map<Integer, Integer> counts = IntStream.of(numbers).boxed().collect(Collectors.toMap(Function.identity(), o -> 0));

        RandomGen randomGen = new RandomGen(numbers, probabilities);
        for (int i = 0; i < 1000; i++) {
            int picked = randomGen.nextNum();
            assertTrue(counts.containsKey(picked));
            counts.merge(picked, 1, Integer::sum);
        }
        System.out.println(counts);
    }
}