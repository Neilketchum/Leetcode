package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "abc";
        // printPermutation(str, "");
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character c:str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<String> list = new ArrayList<>();
        printPermutationOptimzed(str,"",list,map);
        for(String s:list){
            System.out.println(s);
        }

        
    }
    public static void printPermutationOptimzed(String s,String result ,List<String> list,HashMap<Character,Integer> map){
        if(result.length() == s.length()){
            list.add(result);
            return;
        }
        for(Character c:map.keySet()){
            if(map.get(c)>0){
                map.put(c,map.get(c)-1);
                printPermutationOptimzed(s,result+c,list,map);
                map.put(c,map.get(c)+1);
            }
        }
    
    }
    public static void printPermutation(String input, String output) {
       
        if (input.length() == 1) {
            System.out.println(output + input);
            return;
        }
        for(Character c:input.toCharArray()){
            String newInput = input.replaceFirst(String.valueOf(c), "");
            printPermutation(newInput, output + c);
        }
    }
}
