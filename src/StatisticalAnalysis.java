package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StatisticalAnalysis {

    private Iterator<String>  iteratorStatisticalAnalysis;

    private View view;

    private HashMap<String, Integer> dicOfElem;
    private HashMap<String, Integer> dicOfWord;
    private HashMap<String, Integer> dicOfChar;

    private List<HashMap<String, Integer>> arrayOfDics;

    public StatisticalAnalysis(Iterator<String> iteratorToAnalysis){
        long startTime = startTime();
        dicOfWord = new HashMap<>();
        dicOfChar = new HashMap<>();
        arrayOfDics = new ArrayList<HashMap<String, Integer>>();
        view = new View();

        fillDictionary(Application.filenames);
        view.print(String.format("Benchmark time: %.3f seconds", stopTime(startTime)));
    }

    private void fillDictionary(String[] filenames){
        
        for(String oneFile : filenames){
            try{
                dicOfWord.clear();
                dicOfChar.clear();

                FileContent fileContent = new FileContent(oneFile);

                iteratorStatisticalAnalysis = new WordIterator(fileContent);
                addToDic(dicOfWord);

                iteratorStatisticalAnalysis = new CharIterator(fileContent);
                addToDic(dicOfChar);

                calculateValuesAndPrint(dicOfWord, dicOfChar, oneFile);
            } catch (FileNotFoundException e) {
                view.print("File not found! Please input the correct path.");
            } catch (NullPointerException e){
                view.print("This program is working only with parameters. Please insert file name as paramter.");
            } catch (IOException e){
                view.print("The problem with read your file.");
            }
        }
    }

    private void addToDic(HashMap<String, Integer> dic){
        while(iteratorStatisticalAnalysis.hasNext()){
            String word = iteratorStatisticalAnalysis.next();
            if(dic.containsKey(word)){
                int count = dic.get(word);
                dic.put(word, ++count);
            }else{
                dic.put(word, 1);
            }
        }
        arrayOfDics.add(dic);
    }

    private void calculateValuesAndPrint(HashMap<String, Integer> dicOfWord, HashMap<String, Integer> dicOfChar, String filename){
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
            
            view.print(String.format("==%s==", filename));
            view.print(String.format("Char count: %d", countOfChars.intValue()));
            view.print(String.format("Word count: %d", countOfWords));
            view.print(String.format("Dict size: %d", dictSize));
            view.print("Most used words (>1%): ", mostUsedWords);
            view.print(String.format("'love' count: %d", countOfLove));
            view.print(String.format("'hate' count: %d", countOfHate));
            view.print(String.format("'music' count: %d", countOfMusic));
            view.print(String.format("vowels %% : %d", percentOfVowels.intValue()));
            view.print(String.format("a:e count ratio: %.2f", countRatioAE));
            percentOfAlphabet(dicOfElem);
    }

    private void percentOfAlphabet(HashMap<String, Integer> dic){
        String alphabetAsString = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z").toLowerCase();
        String[] alphabet = alphabetAsString.split(" ");
        String textOutput = "";
        for(String letter: alphabet){
            if(dic.containsKey(letter)){
                int count = dic.get(letter);
                double percentValue = ((double)count / (double) size()) * 100.0;
                textOutput += String.format("[ %s -> %.2f] ", letter , percentValue); 
            }
        }
        view.print(textOutput);
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
        Set<String> newSet = new TreeSet<String>();
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

    private static long startTime(){
        return System.nanoTime();
    }

    private static Double stopTime(long startTime){
        long endTime = System.nanoTime();
        Double start = Double.valueOf(startTime);
        Double end = Double.valueOf(endTime);
        return (end - start)/1000000000.0;
    }
}
