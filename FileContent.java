import java.util.Iterator;

public class FileContent implements IterableText {

    private String filename;
    public String fileContent;

    @Override
    public Iterator<String> charIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<String> wordIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getFilename(){
        return filename;
    }
    
} 