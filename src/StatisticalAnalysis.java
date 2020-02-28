package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StatisticalAnalysis {

    public Iterator<String>  statisticalAnalysis;

    private HashMap<String, Integer> dicOfWord;
    private HashMap<String, Integer> dicOfChar;

    public StatisticalAnalysis(String[] filename){
        dicOfWord = new HashMap<>();
        {
            dicOfWord.put("Key",1);
        }
    }

    public int countOf(String... elems){
        return 0;
    }

    public int dictionarySize(){
        return 0;
    }

    public int size(){
        return 0;
    }

    public Set<String> occurMoreThan(Integer n){
        Set<String> newSet = new HashSet<String>();

        return newSet;
    }
}