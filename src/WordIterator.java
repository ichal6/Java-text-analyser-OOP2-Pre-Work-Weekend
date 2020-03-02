package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class WordIterator implements Iterator<String> {
    public FileContent wordIterator;
    private String fromFile;

    WordIterator(String oneFile) throws FileNotFoundException, NullPointerException, IOException{
        wordIterator = new FileContent(false, oneFile);
        fromFile = wordIterator.fileContent;
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
        String[] splitString = fromFile.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < splitString.length; i++) {
            sb.append(splitString[i] + " ");
        }
        fromFile = sb.toString();
        return splitString[0];
    }
    
}