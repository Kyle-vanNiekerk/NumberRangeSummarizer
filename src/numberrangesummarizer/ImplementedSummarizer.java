package numberrangesummarizer;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class ImplementedSummarizer implements NumberRangeSummarizer {

    // Validate user input
    public boolean validateInput(String input){
        boolean bValid = true;
        if (input == "")
        {
            bValid = false;
            System.out.println("Please enter a comma delimited series of numbers");
        }
        for (int i = 0; i < input.length(); i++) {
            // Make sure that input contains only numbers, commas, and spaces
            char myChar = input.charAt(i);
            if (!Character.isDigit(myChar))
            {
                bValid = false;
                if (myChar == ',' || myChar == ' ')
                {
                    bValid = true;
                }
                else{
                    bValid = false;
                    System.out.println("Please ensure that the input contains only numbers, commas, and spaces");
                    break;
                }
                // Null values in series or ",," can cause issues, if input contains any it is invalid
                if (input.contains(",,"))
                {
                    bValid = false;
                    System.out.println("The series cannot contain any NULL values");
                    break;
                }
            }
        }
        return bValid;
    }

    // Splits a given string by delimiter ","
    public String [] splitByComma(String series){
        boolean seriesValidated = validateInput(series);
        if (seriesValidated == false)
        {
            System.exit(0); // Stops execution to avoid errors
        }
        return series.split(",");
    }

    // Store a given series of numbers into a Collection of Integers
    public ArrayList<Integer> collect(String input){
        ArrayList<Integer> result = new ArrayList<>();
        String[] series = splitByComma(input);

        // Removes any spaces from the input, then adding them to a Collection
        // Errors will not occur when converting to int, allows different input formats when none are specified for otherwise valid input
        for (String s : series) {
            result.add(Integer.parseInt(s.replaceAll(" ", "")));
        }

        return result;
    }

    // Summarizes the collection in a String
    public String summarizeCollection(Collection<Integer> input){
        StringBuilder result = new StringBuilder();
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
                result.append(temp).append(sequential + (numberList.get(i) - 1));
                i+= sequential-1;
            }
            else{
                // If the adjacent numbers are not sequential
                result.append(numberList.get(i).toString());
            }
            
            // Last number/sequence does not get comma, but the rest do
            if (i < size-1)
            {
                result.append(", ");
            }
        }

        return result.toString();
    }
}