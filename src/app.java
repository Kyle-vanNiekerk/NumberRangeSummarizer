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

        // Debugging:
        ImplementedSummarizer rf = new ImplementedSummarizer();
        FileReader reader = new FileReader();

        // Read From Specified File
        String inputLine = reader.getInput("src/data/", "input");
        System.out.println("input:" + '\t' + inputLine);

        // Split line by delimiter "," into an array
        /*String[] splitSeries = rf.splitByComma(inputLine);
        for (int i = 0; i < splitSeries.length; i++) {
            System.out.println(splitSeries[i]);
        }*/

        // collect the series
        ArrayList<Integer> seriesIntegers = rf.collect(inputLine);
        // summarize the series
        String seriesSummarized = rf.summarizeCollection(seriesIntegers);
        System.out.println("output:" + '\t' + seriesSummarized);

    }
}


