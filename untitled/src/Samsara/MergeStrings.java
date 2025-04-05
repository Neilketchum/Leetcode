package Samsara;

public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int k = 0;  
        if(word1 == null && word2 == null){
            return new String();
        }else if(word1 == null){
            return word2;
        }else if(word2 == null){
            return word1;
        }
        char[] resultCharArray = new char[word1.length() + word2.length()];

        while(i < word1.length() && j < word2.length()){
            if(k%2 == 0){
                resultCharArray[k] = word1.charAt(i);
                i++;
            }else{
                resultCharArray[k] = word2.charAt(j);
                j++;
            }
            k++;
        }
        while(i<word1.length()-1){
            resultCharArray[k] = word1.charAt(i);
            i++;
        }
        while(j<word2.length()-1){
            resultCharArray[k] = word2.charAt(j);
            j++;
        }
       return new String(resultCharArray);
    }
    public static void main(String[] args) {
        System.out.println("abcdef".substring(0,6));
    }
}
