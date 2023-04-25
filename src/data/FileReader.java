package data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Kyle van Niekerk
*/

public class FileReader {
    // Open a specified text file in a specified directory to read the input from
    // This is easier than entering input into a terminal and neater than hardcoding it
    public ArrayList<String> getInput(String path, String filename) {
        String filepath = path + filename + ".txt";
        ArrayList<String> result = new ArrayList<>();
    
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            int counter = 0;
    
            while (myReader.hasNextLine()) {  // Only read the first line
                String data = myReader.nextLine();
                result.add(data);
                counter++;
            }
            myReader.close();
            System.out.println("Successfully read " + counter + " lines of input from " + filepath);
        
        }   catch (Exception e) {
                System.out.println("File '"+ filename +".txt' does not exist");
                System.exit(0);
            }

            return result;
        }
}
