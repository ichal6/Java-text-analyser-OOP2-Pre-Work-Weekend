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
            dicOfWord.put("key",10);
            dicOfWord.put("word",1);
            dicOfWord.put("emaus",3);
        }
        System.out.println(countOf());
        System.out.println(dictionarySize());
    }

    public int countOf(String... elems){
        int count = 0;
        for(String oneString : elems){
            if(dicOfWord.containsKey(oneString)){
               count += dicOfWord.get(oneString);
            }
        }
        
        return count;
    }

    public int dictionarySize(){
        Set<String> setOfWords = dicOfWord.keySet();
        return setOfWords.size();

        //return 0;
    }

    public int size(){
        return 0;
    }

    public Set<String> occurMoreThan(Integer n){
        Set<String> newSet = new HashSet<String>();

        return newSet;
    }
}