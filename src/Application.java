package src;

import java.util.Iterator;

public class Application {
    static String[] filenames;

    public static void main(String[] args) {
        filenames = args;
        
        Iterator<String>  iteratorToAnalysis = null;
        new StatisticalAnalysis(iteratorToAnalysis);
    }
}
