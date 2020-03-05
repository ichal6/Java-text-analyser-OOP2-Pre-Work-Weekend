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
                view.print(String.format("==%s==", oneFile));
                FileContent fileContent = new FileContent(oneFile);
                Iterator<String>  iteratorToAnalysis = new WordIterator(fileContent);
                new StatisticalAnalysis(iteratorToAnalysis);
                iteratorToAnalysis = new CharIterator(fileContent);
                new StatisticalAnalysis(iteratorToAnalysis);
            } catch (FileNotFoundException e) {
                view.print("File not found! Please input the correct path.");
            } catch (NullPointerException e){
                view.print("This program is working only with parameters. Please insert file name as paramter.");
            } catch (IOException e){
                view.print("The problem with read your file.");
            }        
        
        }
    }

}
