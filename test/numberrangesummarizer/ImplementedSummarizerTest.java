package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImplementedSummarizerTest {

    ImplementedSummarizer myNumberRangeSummarizer = new ImplementedSummarizer();

    @org.junit.jupiter.api.Test
    void splitExampleByComma() {

        String[] result = myNumberRangeSummarizer.splitByComma("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String[] expectedResult = {"1","3","6","7","8","12","13","14","15","21","22","23","24","31"};
        assertArrayEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    void collectExampleSeries() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        ArrayList<Integer> resultList = myNumberRangeSummarizer.collect(input);
        int[] expectedResult = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        int[] result = resultList.stream().mapToInt(i->i).toArray();
        assertArrayEquals(expectedResult, result);

    }

    @org.junit.jupiter.api.Test
    void summarizeExampleCollection() {
        Integer[] input = new Integer[] { 1,3,6,7,8,12,13,14,15,21,22,23,24,31 };
        List<Integer> inputList = Arrays.asList(input);
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";
        String result = myNumberRangeSummarizer.summarizeCollection(inputList);
        assertEquals(expectedResult, result);
    }
}