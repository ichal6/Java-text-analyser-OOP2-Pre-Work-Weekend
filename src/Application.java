package src;

public class Application{
    public static void main(String[] args){
        long startTime = startTime();
        new StatisticalAnalysis(args);
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