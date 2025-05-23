public class MergeStringAlternate {
    public static String mergeAlternately(String word1, String word2) {
        int i  =0 ,j=0,k=0;
        StringBuilder result = new StringBuilder();
        while(i<word1.length() && j < word2.length()){
            if(k%2==0){
                result.append(word1.charAt(i));
                i++;
            }else{
                result.append(word2.charAt(j));
                j++;
            }
            k++;
        }
        while(i<word1.length()){
            result.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            result.append(word2.charAt(j));
            j++;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pq"));
    }
}
