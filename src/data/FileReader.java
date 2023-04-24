package data;

import java.io.File;
import java.util.Scanner;

/*
 * @author Kyle van Niekerk
*/

public class FileReader {
    // Open a specified text file in a specified directory to read the input from
    // This is easier than entering input into a terminal and neater than hardcoding it
    public String getInput(String path, String filename) {
        String filepath = path + filename + ".txt";
        String result = "";
    
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
    
            //while (myReader.hasNextLine()) {  // Only read the first line
                String data = myReader.nextLine();
                result = data;
            //}
            myReader.close();
        
        }   catch (Exception e) {
                System.out.println("File '"+ filename +".txt' does not exist");
                System.exit(0);
            }

            return result;
        }
}
