package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Application {
    static String[] filenames;
    static View view;
    private static Iterator<String>  iterator;

    public static void main(String[] args) {
        view = new View();
        for(String oneFile : args){
            try{
                long startTime = startTime();
                FileContent fileContent = new FileContent(oneFile);
                view.print(String.format("==%s==", fileContent.getFilename()));
                iterator = fileContent.wordIterator();
                new StatisticalAnalysis(iterator);
                iterator = fileContent.charIterator();
                new StatisticalAnalysis(iterator);
                view.print(String.format("Benchmark time: %.3f seconds", stopTime(startTime)));
            } catch (FileNotFoundException e) {
                view.print(String.format("%s not found! Please input the correct path.", oneFile));
            } catch (IOException e){
                view.print(String.format("The problem with read your file - ", oneFile));
            }        
        }
    }

    private static long startTime(){
        return System.nanoTime();
    }

    private static Double stopTime(long startTime){
        long endTime = System.nanoTime();
        Double start = Double.valueOf(startTime);
        Double end = Double.valueOf(endTime);
        return (end - start)/1000000000.0;
    }

}
