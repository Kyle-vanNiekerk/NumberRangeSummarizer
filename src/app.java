import java.util.ArrayList;
import numberrangesummarizer.ImplementedSummarizer;
import data.FileReader;

public class app {
    public static void main(String[] args) {

        /*
         *  app.java will read the series of numbers from the specified input file
         *  and summarize them in a comma delimited list, and group them by range
         *  when they are sequential.
         */

        ImplementedSummarizer rf = new ImplementedSummarizer();

        // Hardcoded solution, this will always execute regardless of whether a text file containing input is present
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        System.out.println("Hardcoded Series: " + input);
        ArrayList<Integer> hardCodedSeries = rf.collect(input);
        String summarizedRange = rf.summarizeCollection(hardCodedSeries);
        System.out.println("Hardcoded Series Summarized: " + summarizedRange);
        System.out.println('\n');


        // Read from specified file
        FileReader reader = new FileReader();
        ArrayList<String> inputLines = reader.getInput("src/data/", "input");
        for (int i = 0; i < inputLines.size(); i++) {
            System.out.println("Line" + Integer.toString(i+1) + ":");

            System.out.println('\t' +"input:" + '\t' + inputLines.get(i)); // Display line number
            // collect the series
            ArrayList<Integer> seriesIntegers = rf.collect(inputLines.get(i));
            // summarize the series
            String seriesSummarized = rf.summarizeCollection(seriesIntegers);
            System.out.println('\t' +"output:" + '\t' + seriesSummarized);
        }



    }
}


