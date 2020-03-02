package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class CharIterator implements Iterator<String> {
    public FileContent charIterator;
    private String fromFile;
    private String[] splitFromFile;
    private int count;

    CharIterator(String oneFile) throws FileNotFoundException, NullPointerException, IOException{
        charIterator = new FileContent(true, oneFile) ;
        fromFile = charIterator.fileContent;
        splitFromFile = fromFile.split("");
        count = 0;
    }

    @Override
    public boolean hasNext() {
        if(count >= splitFromFile.length){
            return false;
        }
        return true;
    }
    
    @Override
    public String next() {
        return splitFromFile[count++];
    }
    
}