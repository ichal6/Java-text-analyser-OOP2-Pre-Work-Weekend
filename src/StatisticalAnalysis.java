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
        statisticalAnalysis = new WordIterator();
        dicOfWord = new HashMap<>();
        while(statisticalAnalysis.hasNext()){
            String word = statisticalAnalysis.next();
            if(dicOfWord.containsKey(word)){
                int count = dicOfWord.get(word);
                dicOfWord.put(word, count++);
            }else{
                dicOfWord.put(word, 1);
            }
            
        }
        /*
        {
            dicOfWord.put("key",100);
            dicOfWord.put("word",1);
            dicOfWord.put("emaus",3);
        }*/
        System.out.println(countOf());
        System.out.println(dictionarySize());
        System.out.println(size());
        System.out.println(occurMoreThan(1));
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
        return dicOfWord.size();
    }

    public int size(){
        int size = 0;
        for(int values : dicOfWord.values()){
            size += values;
        }
        return size;
    }

    public Set<String> occurMoreThan(Integer n){
        Set<String> newSet = new HashSet<String>();
        Double size = Double.valueOf(size());
        Double value;
        Double percent = Double.valueOf(0);
        for(String key: dicOfWord.keySet()){
            value = Double.valueOf(dicOfWord.get(key));
            percent = (value / size) * 100.0;
            if(percent > n){
                newSet.add(key);
            }
        }
        return newSet;
    }
}