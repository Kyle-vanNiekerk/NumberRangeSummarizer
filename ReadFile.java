import java.io.File;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReadFile /*implements NumberRangeSummarizer*/ {
    // Error whith summarizeCollection function, change parameter type

    // Open a specified text file in a specified directory to read the input from
    public String getInput(String filename) {
        String pathname = filename + ".txt";
        String result = "";
    
        try {
            File myObj = new File(pathname);
            Scanner myReader = new Scanner(myObj);
    
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result = data;
            }
            myReader.close();
        
        }   catch (Exception e) {
                System.out.println("File '"+ filename +".txt' does not exist");
            }
    
            return result;
        }

    // Splits a string by delimiter ","
    public String [] splitByComma(String series){
        String[] result = series.split(",");
        return result;
    }

    // Splits a string by dilimeter "," and stores data in an ArrayList Collection
    public ArrayList<Integer> collect(String input){
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] series = splitByComma(input);

        for (int i = 0; i < series.length; i++) {
        result.add(Integer.parseInt(series[i]));
        }
        return result;
    }

    // Summarizes the collection
    public String summarizeCollection(ArrayList<Integer> input){        
        String result = "";

        for (int i = 0; i < input.size()-1; i++) {
            if ((input.get(i+1) == input.get(i)+1) /*&& (i+1 < input.size())*/) // Possible out of bounds error
            {
                String temp = input.get(i).toString() + "-";
                int sequential = 0;
                while (input.get(i) + sequential == input.get(i + sequential))
                {
                    sequential++;
                }
                result += temp + Integer.toString(sequential + (input.get(i) - 1));
                i+= sequential-1;
            }
            else{
                result += input.get(i).toString();
            }
            
            if (i < input.size()-1)
            result += ", ";

        }
        result += input.get(input.size()-1).toString(); // should be part of the loop
        return result;
    }
}


