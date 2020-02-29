package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StatisticalAnalysis {

    public Iterator<String>  statisticalAnalysis;

    private HashMap<String, Integer> dicOfElem;
    private HashMap<String, Integer> dicOfWord;
    private HashMap<String, Integer> dicOfChar;

    private List<HashMap<String, Integer>> arrayOfDics;

    public StatisticalAnalysis(String[] filenames){
        dicOfWord = new HashMap<>();
        dicOfChar = new HashMap<>();
        arrayOfDics = new ArrayList<HashMap<String, Integer>>();

        fillDictionary(filenames);
    }

    private void fillDictionary(String[] filenames){
        for(String oneFile : filenames){
            statisticalAnalysis = new WordIterator(oneFile);
            addToDic(dicOfWord);

            statisticalAnalysis = new CharIterator(oneFile);
            addToDic(dicOfChar);

            calculateValues(dicOfWord, dicOfChar, oneFile);
            
        }

    }

    private void calculateValues(HashMap<String, Integer> dicOfWord, HashMap<String, Integer> dicOfChar, String filename){
            dicOfElem = dicOfWord;
            int countOfWords = size();
            int dictSize = dictionarySize();
            Set<String> mostUsedWords = occurMoreThan(1);
            int countOfLove = countOf("love");
            int countOfHate = countOf("hate");
            int countOfMusic = countOf("music");

            dicOfElem = dicOfChar;
            Double countOfChars = Double.valueOf(size());
            Double countOfVowels = Double.valueOf(countOf("A", "E", "I", "O", "U"));
            Double percentOfVowels = (countOfVowels / countOfChars) * Double.valueOf(100.0);
            double countRatioAE = (double)countOf("A")/(double)countOf("E");
            
            System.out.println("==" + filename + "==");
            System.out.println("Char count: " + countOfChars);
            System.out.println("Word count: " + countOfWords);
            System.out.println("Dict size: " + dictSize);
            System.out.println("Most used words (>1%): " + mostUsedWords);
            System.out.println("/'love/' count: " + countOfLove);
            System.out.println("/'hate/' count: " + countOfHate);
            System.out.println("/'music/' count: " + countOfMusic);
            System.out.println("vowels %: " + percentOfVowels);
            System.out.println("a:e count ratio: " + countRatioAE);
            percentOfAlphabet(dicOfElem);
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
        arrayOfDics.add(dic);
    }

    private void percentOfAlphabet(HashMap<String, Integer> dic){
        String alphabetAsString = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z").toLowerCase();
        String[] alphabet = alphabetAsString.split(" ");
        for(String letter: alphabet){
            if(dic.containsKey(letter)){
                int count = dic.get(letter);
                double percentValue = ((double)count / (double) size()) * 100.0;
                System.out.print(String.format("[ %s -> %.2f] ", letter , percentValue)); 
            }
        }
        System.out.println();
    }

    public int countOf(String... elems){
        int count = 0;
        for(String oneString : elems){
            oneString = oneString.toLowerCase();
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