package src;

import java.util.Iterator;

public class WordIterator implements Iterator<String> {
    public FileContent wordIterator;
    private String fromFile;

    WordIterator(){
        wordIterator = new FileContent(false);
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
        String[] splitString = fromFile.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < splitString.length; i++) {
            sb.append(splitString[i] + " ");
        }
        fromFile = sb.toString();
        return splitString[0];
    }
    
}