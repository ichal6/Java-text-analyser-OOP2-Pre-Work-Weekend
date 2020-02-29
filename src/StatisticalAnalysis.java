package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StatisticalAnalysis {

    public Iterator<String>  statisticalAnalysis;

    private HashMap<String, Integer> dicOfElem;
    private HashMap<String, Integer> dicOfWord;
    private HashMap<String, Integer> dicOfChar;

    public StatisticalAnalysis(String[] filename){
        dicOfWord = new HashMap<>();
        dicOfChar = new HashMap<>();

        statisticalAnalysis = new WordIterator();
        addToDic(dicOfWord);

        statisticalAnalysis = new CharIterator();
        addToDic(dicOfChar);

        dicOfElem = dicOfChar;
        //Move to View bottom code
        System.out.println(countOf("string"));
        System.out.println(dictionarySize());
        System.out.println(size());
        System.out.println(occurMoreThan(1));
    }

    private void addToDic(HashMap<String, Integer> dic){
        while(statisticalAnalysis.hasNext()){
            String word = statisticalAnalysis.next();
            if(dic.containsKey(word)){
                int count = dic.get(word);
                dic.put(word, ++count);
            }else{
                dic.put(word, 1);
            }
        }
    }

    public int countOf(String... elems){
        int count = 0;
        for(String oneString : elems){
            if(dicOfElem.containsKey(oneString)){
               count += dicOfElem.get(oneString);
            }
        }
        
        return count;
    }

    public int dictionarySize(){
        return dicOfElem.size();
    }

    public int size(){
        int size = 0;
        for(int values : dicOfElem.values()){
            size += values;
        }
        return size;
    }

    public Set<String> occurMoreThan(Integer n){
        Set<String> newSet = new HashSet<String>();
        Double size = Double.valueOf(size());
        Double value;
        Double percent = Double.valueOf(0);
        for(String key: dicOfElem.keySet()){
            value = Double.valueOf(dicOfElem.get(key));
            percent = (value / size) * 100.0;
            if(percent > n){
                newSet.add(key);
            }
        }
        return newSet;
    }
}