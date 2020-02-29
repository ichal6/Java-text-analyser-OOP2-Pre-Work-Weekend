package src;

import java.util.Iterator;

public class FileContent implements IterableText {

    private String filename;
    public String fileContent;

    FileContent(boolean toCharIterator, String filename){
        // Implement methods to read from file and assign to fileContent value
        this.filename = filename;
        this.fileContent = "This is example string It is example text in this String";
        this.fileContent = this.fileContent.toLowerCase();

        removeWhiteSpaces(toCharIterator);
               
    }

    private void removeWhiteSpaces(boolean toCharIterator){
        if(toCharIterator){
            String[] splitString = fileContent.split(" ");
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < splitString.length; i++) {
                sb.append(splitString[i]);
            }
            fileContent = sb.toString();
        } 
    }

    @Override
    public Iterator<String> charIterator() {
        Iterator<String> newIterator = new CharIterator(filename); 
        // TODO Auto-generated method stub
        return newIterator;
    }

    @Override
    public Iterator<String> wordIterator() {
        Iterator<String> newIterator = new WordIterator(filename); 
        // TODO Auto-generated method stub
        return newIterator;
    }

    public String getFilename(){
        return filename;
    }
    
} 