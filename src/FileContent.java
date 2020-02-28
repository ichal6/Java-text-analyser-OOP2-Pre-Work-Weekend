package src;

import java.util.Iterator;

public class FileContent implements IterableText {

    private String filename;
    public String fileContent;

    FileContent(){
        this.fileContent = "This is example string It is example text in this String";
        this.fileContent = this.fileContent.toLowerCase();
    }

    @Override
    public Iterator<String> charIterator() {
        Iterator<String> newIterator = new CharIterator(); 
        // TODO Auto-generated method stub
        return newIterator;
    }

    @Override
    public Iterator<String> wordIterator() {
        Iterator<String> newIterator = new WordIterator(); 
        // TODO Auto-generated method stub
        return newIterator;
    }

    public String getFilename(){
        return filename;
    }
    
} 