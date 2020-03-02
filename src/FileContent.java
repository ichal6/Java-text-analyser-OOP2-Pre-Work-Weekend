package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileContent implements IterableText {

    private String filename;
    public String fileContent;

    FileContent(boolean toCharIterator, String filename) throws FileNotFoundException, NullPointerException, IOException{
        this.filename = filename;
        
        readFromFile();
        
        this.fileContent = this.fileContent.toLowerCase();
        if(toCharIterator){
            removeWhiteSpaces();
        }      
    }

    private void readFromFile() throws FileNotFoundException, NullPointerException, IOException{
        // Implement methods to read from file and assign to fileContent value
        File file = new File(filename); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        while (br.ready()){
            fileContent += br.readLine();
        }
        br.close();
        
    }

    private void removeWhiteSpaces(){
        String[] splitString = fileContent.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < splitString.length; i++) {
            sb.append(splitString[i]);
        }
        fileContent = sb.toString();
    }

    @Override
    public Iterator<String> charIterator() throws FileNotFoundException, NullPointerException, IOException {
        Iterator<String> newIterator = new CharIterator(filename); 
        return newIterator;
    }

    @Override
    public Iterator<String> wordIterator()  throws FileNotFoundException, NullPointerException, IOException {
        Iterator<String> newIterator = new WordIterator(filename); 
        return newIterator;
    }

    public String getFilename(){
        return filename;
    }
    
} 