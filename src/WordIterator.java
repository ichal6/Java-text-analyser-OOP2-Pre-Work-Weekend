package src;

import java.util.Iterator;

public class WordIterator implements Iterator<String> {
    public FileContent wordIterator;
    private String fromFile = "This is example string It is example text in this String"; //To test -remove after write class FileContent

    WordIterator(){
        fromFile = fromFile.toLowerCase();
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
        String[] splitString = fromFile.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < splitString.length; i++) {
            sb.append(splitString[i] + " ");
        }
        fromFile = sb.toString();
        return splitString[0];
    }
    
}