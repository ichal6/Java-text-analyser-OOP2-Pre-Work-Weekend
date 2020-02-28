package src;

import java.util.Iterator;

public class WordIterator implements Iterator {
    public FileContent wordIterator;
    private String fromFile = "This is example string. It is example text in this String"; //To test -remove after write class FileContent


    @Override
    public boolean hasNext() {
        if(fromFile == "" || fromFile == " "){
            return false;
        }
        return true;
    }

    @Override
    public String next() {
        String[] splitString = fromFile.split(" ");
        return splitString[0];
    }
    
}