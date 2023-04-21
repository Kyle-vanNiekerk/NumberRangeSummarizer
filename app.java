import java.util.ArrayList;

public class app {
    public static void main(String[] args) {
        
        //DEBUGGING

        ReadFile rf = new ReadFile();

        // Read From Specified File
        String inputLine = rf.getInput("input");
        //System.out.println(inputLine);

        // Split line by delimiter "," into an array
        String[] splitSeries = rf.splitByComma(inputLine);
        for (int i = 0; i < splitSeries.length; i++) {
            //System.out.println(splitSeries[i]);
        }
        
        // collect series
        ArrayList<Integer> seriesIntegers = rf.collect(inputLine);
        System.out.println(rf.summarizeCollection(seriesIntegers));
    }    
}


