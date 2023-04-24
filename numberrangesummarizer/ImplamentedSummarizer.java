package numberrangesummarizer;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class ImplamentedSummarizer implements NumberRangeSummarizer {

    // Splits a given string by delimiter ","
    public String [] splitByComma(String series){
        String[] result = series.split(",");
        return result;
    }

    // Store a given series of numbers into a Collection of Integers
    public ArrayList<Integer> collect(String input){
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] series = splitByComma(input);

        for (int i = 0; i < series.length; i++) {
        result.add(Integer.parseInt(series[i]));
        }

        return result;
    }

    // Summarizes the collection in a String
    public String summarizeCollection(Collection<Integer> input){
        String result = "";
        int size = input.size();

        // Copies the input from a collection to an ArrayList, the input cannot be treated as an arraylist directly
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i< size; i++)
        {
            numberList.addAll(input);
        }

        for (int i = 0; i < size; i++) {
            if ((numberList.get(i+1) == numberList.get(i)+1))
            {
                // If adjacent numbers are sequential
                String temp = numberList.get(i).toString() + "-";
                int sequential = 0;
                while (numberList.get(i) + sequential == numberList.get(i + sequential))
                {
                    sequential++;
                }
                result += temp + Integer.toString(sequential + (numberList.get(i) - 1));
                i+= sequential-1;
            }
            else{
                // If the adjacent numbers are not sequential
                result += numberList.get(i).toString();
            }
            
            // Last number/sequence does not get comma, but the rest do
            if (i < size-1)
            result += ", ";
        }

        return result;
    }
}