import java.io.File;
import java.util.Scanner;

public class ReadFile {

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
                System.out.println("File 'input.txt' does not exist");
            }
    
            return result;
        }

    public String [] splitByComma(String series){
        String[] result = series.split(",");
        return result;
    }
}


