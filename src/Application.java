package src;

public class Application{
    public static void main(String[] args){
        long startTime = System.nanoTime();
        new StatisticalAnalysis(args);
        long endTime = System.nanoTime();
        Double start = Double.valueOf(startTime);
        Double end = Double.valueOf(endTime);
        System.out.println((end - start)/1000000000.0 + " seconds");

    }


}