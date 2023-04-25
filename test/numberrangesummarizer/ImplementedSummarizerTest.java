package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImplementedSummarizerTest {

    ImplementedSummarizer myNumberRangeSummarizer = new ImplementedSummarizer();

    // Tests to see if a valid series of numbers (from the example) is split correctly by comma delimiters
    @org.junit.jupiter.api.Test
    void splitExampleByCommaTest() {
        String[] result = myNumberRangeSummarizer.splitByComma("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String[] expectedResult = {"1","3","6","7","8","12","13","14","15","21","22","23","24","31"};
        assertArrayEquals(expectedResult, result);
    }

    // This tests the implementation collect() function
    // Tests to see if a valid series of numbers is split and placed into a Collection of integers correctly
    @org.junit.jupiter.api.Test
    void collectExampleSeriesTest() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        ArrayList<Integer> resultList = myNumberRangeSummarizer.collect(input);
        int[] expectedResult = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        int[] result = resultList.stream().mapToInt(i->i).toArray();
        assertArrayEquals(expectedResult, result);

    }

    // This tests the implementation of the summarizeCollection() function
    // Tests to see if a Collection of Integers is correctly summarized by range if sequential (as per example)
    @org.junit.jupiter.api.Test
    void summarizeExampleCollectionTest() {
        Integer[] input = new Integer[] { 1,3,6,7,8,12,13,14,15,21,22,23,24,31 };
        List<Integer> inputList = Arrays.asList(input);
        String expectedResult = "1, 3, 6-8, 12-15, 21-24, 31";
        String result = myNumberRangeSummarizer.summarizeCollection(inputList);
        assertEquals(expectedResult, result);
    }

    // Tests to see if valid input is successfully validated
    @org.junit.jupiter.api.Test
    void validateValidTest() {
        boolean result = myNumberRangeSummarizer.validateInput("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(result,true);
    }

    // Tests to see if validation method detects an empty series
    @org.junit.jupiter.api.Test
    void validateNullTest() {
        boolean result = myNumberRangeSummarizer.validateInput("");
        assertEquals(result, false);
    }

    // Tests to see if validation method detects non-numerical values in the series
    @org.junit.jupiter.api.Test
    void validateInvalidCharTest() {
        boolean result = myNumberRangeSummarizer.validateInput("1,#,a,5,b");
        assertEquals(result,false);
    }


}