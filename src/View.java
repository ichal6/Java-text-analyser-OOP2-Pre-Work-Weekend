package src;

import java.util.Set;

public class View {
    public void print(String str){
        System.out.println(str);
    }

    public void print(String text, Set<String> set){
        System.out.print(text);
        System.out.println(set);
    }
}
