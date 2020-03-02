package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class WordIterator implements Iterator<String> {
    public FileContent wordIterator;
    private String fromFile;
    private String[] splitFromFile;
    private int count;

    WordIterator(String oneFile) throws FileNotFoundException, NullPointerException, IOException{
        wordIterator = new FileContent(false, oneFile);
        fromFile = wordIterator.fileContent;
        splitFromFile = fromFile.split("\\s+");
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