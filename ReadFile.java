import java.io.File;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// The interface NumberRangeSummarizer is part of a package of the same name,
// to be used without modification it needs to be imported like this:
import numberrangesummarizer.NumberRangeSummarizer;

public class ReadFile implements NumberRangeSummarizer {
    // ToDo:
    // Fix out of bounds error in summarizeCollection loop

    // Open a specified text file in a specified directory to read the input from
    // This is easier than entering input into a terminal and neater than hardcoding it
    public String getInput(String filename) {
        String pathname = filename + ".txt";
        String result = "";
    
        try {
            File myObj = new File(pathname);
            Scanner myReader = new Scanner(myObj);
    
            //while (myReader.hasNextLine()) {  // Only read the first line
                String data = myReader.nextLine();
                result = data;
            //}
            myReader.close();
        
        }   catch (Exception e) {
                System.out.println("File '"+ filename +".txt' does not exist");
            }
            return result;
        }

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

    // Summarizes the collection
    public String summarizeCollection(Collection<Integer> input){
        String result = "";
        List<Integer> myList = new ArrayList<>();

        // Copies the input from a collection to an ArrayList, the input cannot be treated as an arraylist directly
        for (int i = 0; i< input.size(); i++)
        {
            myList.addAll(input);
        }

        for (int i = 0; i < input.size()-1; i++) {
            if ((myList.get(i+1) == myList.get(i)+1) /*&& (i+1 < input.size())*/) // Possible out of bounds error < max
            {
                // Sequential
                String temp = myList.get(i).toString() + "-";
                int sequential = 0;
                while (myList.get(i) + sequential == myList.get(i + sequential))
                {
                    sequential++;
                }
                result += temp + Integer.toString(sequential + (myList.get(i) - 1));
                i+= sequential-1;
            }
            else{
                // Non-Sequential
                result += myList.get(i).toString();
            }
            
            // Last number/sequence does not get comma
            if (i < input.size()-1)
            result += ", ";

        }
        // Last number, when not part of sequence
        result += myList.get(input.size()-1).toString(); // should be part of the loop
        return result;
    }
}


