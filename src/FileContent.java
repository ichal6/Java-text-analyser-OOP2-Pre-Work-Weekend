package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileContent implements IterableText {

    private String filename;
    public String contentFromFile;

    FileContent(String filename) throws FileNotFoundException, NullPointerException, IOException{
        this.filename = filename;
        this.contentFromFile = "";
        
        readFromFile();
        
        this.contentFromFile = this.contentFromFile.toLowerCase();   
    }

    private void readFromFile() throws FileNotFoundException, NullPointerException, IOException{
        // Implement methods to read from file and assign to fileContent value
        File file = new File(filename); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        while (br.ready()){
            contentFromFile += br.readLine() + " ";
        }
        br.close();
        
    }

    @Override
    public Iterator<String> charIterator() throws FileNotFoundException, NullPointerException, IOException {
        Iterator<String> newIterator = new CharIterator(new FileContent(filename)); 
        return newIterator;
    }

    @Override
    public Iterator<String> wordIterator()  throws FileNotFoundException, NullPointerException, IOException {
        Iterator<String> newIterator = new WordIterator(new FileContent(filename)); 
        return newIterator;
    }

    public String getFilename(){
        return filename;
    }  
}
