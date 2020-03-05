package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Application {
    static String[] filenames;
    static View view;

    public static void main(String[] args) {
        view = new View();
        filenames = args;
        for(String oneFile : args){
            try{
                long startTime = startTime();
                view.print(String.format("==%s==", oneFile));
                FileContent fileContent = new FileContent(oneFile);
                Iterator<String>  iteratorToAnalysis = new WordIterator(fileContent);
                new StatisticalAnalysis(iteratorToAnalysis);
                iteratorToAnalysis = new CharIterator(fileContent);
                new StatisticalAnalysis(iteratorToAnalysis);
                view.print(String.format("Benchmark time: %.3f seconds", stopTime(startTime)));
            } catch (FileNotFoundException e) {
                view.print("File not found! Please input the correct path.");
            } catch (NullPointerException e){
                view.print("This program is working only with parameters. Please insert file name as paramter.");
            } catch (IOException e){
                view.print("The problem with read your file.");
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
