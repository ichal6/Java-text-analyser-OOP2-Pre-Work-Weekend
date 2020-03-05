package src;

import java.util.Iterator;

public class CharIterator implements Iterator<String> {
    private String fromFile;
    private String[] splitFromFile;
    private int count;

    CharIterator(FileContent charIterator){
        fromFile = charIterator.contentFromFile;
        removeWhiteSpaces();
        splitFromFile = fromFile.split("");
        count = 0;
    }

    private void removeWhiteSpaces(){
        String[] splitString = fromFile.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < splitString.length; i++) {
            sb.append(splitString[i]);
        }
        fromFile = sb.toString();
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
