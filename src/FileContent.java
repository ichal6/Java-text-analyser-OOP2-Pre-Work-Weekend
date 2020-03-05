package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileContent implements IterableText {

    private String filename;
    String contentFromFile;

    public FileContent(String filename) throws FileNotFoundException, IOException{
        this.filename = filename;
        this.contentFromFile = "";
        
        readFromFile();
        
        this.contentFromFile = this.contentFromFile.toLowerCase();   
    }

    private void readFromFile() throws FileNotFoundException, IOException{
        // Implement methods to read from file and assign to fileContent value
        File file = new File(filename); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        while (br.ready()){
            contentFromFile += br.readLine() + " ";
        }
        br.close();
        
    }

    @Override
    public Iterator<String> charIterator(){
        Iterator<String> newIterator = new CharIterator(this); 
        return newIterator;
    }

    @Override
    public Iterator<String> wordIterator(){
        Iterator<String> newIterator = new WordIterator(this);
        return newIterator;
    }

    public String getFilename(){
        return filename;
    }  
}
