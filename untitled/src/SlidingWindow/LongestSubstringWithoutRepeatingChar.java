package SlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        int longestSubstring = Integer.MIN_VALUE;
        Set<Character> slidingWindow = new HashSet<>();
        int left  = 0;
        for (int i = 0; i < s.length() ; i++) {
            if(slidingWindow.contains(s.charAt(i))){
                while (!slidingWindow.isEmpty() && slidingWindow.contains(s.charAt(i))){
                    slidingWindow.remove(s.charAt(left));
                    left++;
                }
                slidingWindow.add(s.charAt(i));
            }else{
                slidingWindow.add(s.charAt(i));
                longestSubstring = Math.max(longestSubstring,slidingWindow.size());
            }
        }
        return longestSubstring;
    }
    public  static int lengthOfLongestSubstringMp(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();

        int start = 0;
        int end = 0;
        int currentLongest = 0;
        int longest = 0;
        for(int i =0;i<s.length();i++){
            end++;
            if(mp.containsKey(s.charAt(i))){
                currentLongest = end - start  ;
                longest = Math.max(currentLongest,longest);
                start = mp.get(s.charAt(i)) + 1 ;
                mp.put(s.charAt(i),i);
            }else{
                mp.put(s.charAt(i),i);
            }
        }
     
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringMp("abcabcbb"));
    }
}