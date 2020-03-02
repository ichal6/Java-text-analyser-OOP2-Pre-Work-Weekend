package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public interface IterableText{

    public Iterator<String> charIterator() throws FileNotFoundException, NullPointerException, IOException ;
    
    public Iterator<String> wordIterator() throws FileNotFoundException, NullPointerException, IOException ;

}