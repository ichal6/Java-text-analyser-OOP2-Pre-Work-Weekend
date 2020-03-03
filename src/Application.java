package src;

import java.util.Iterator;

public class Application {
    static String[] filenames;
    //static long timeRun;

    public static void main(String[] args) {
        long startTime = startTime();

        filenames = args;
        
        Iterator<String>  iteratorToAnalysis = null;
        new StatisticalAnalysis(iteratorToAnalysis);
        
        stopTime(startTime);
    }

    private static long startTime(){
        return System.nanoTime();
    }

    private static void stopTime(long startTime){
        long endTime = System.nanoTime();
        Double start = Double.valueOf(startTime);
        Double end = Double.valueOf(endTime);
        System.out.println((end - start)/1000000000.0 + " seconds");
    }
}