package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class CharIterator implements Iterator<String> {
    public FileContent charIterator;
    private String fromFile;

    CharIterator(String oneFile) throws FileNotFoundException, NullPointerException, IOException{
        charIterator = new FileContent(true, oneFile) ;
        fromFile = charIterator.fileContent;
    }

    @Override
    public boolean hasNext() {
        if(fromFile.equals("") || fromFile.equals(" ")){
            return false;
        }
        return true;
    }
    
    @Override
    public String next() {
        String[] splitString = fromFile.split("");
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < splitString.length; i++) {
            sb.append(splitString[i]);
        }
        fromFile = sb.toString();
        return splitString[0];
    }
    
}