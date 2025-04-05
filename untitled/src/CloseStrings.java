import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CloseStrings {
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        Set<Character>word1Set = new HashSet<>();
        Set<Character>word2Set = new HashSet<>();
        HashMap<Character,Integer> freqWord1 = new HashMap<>();
        HashMap<Character,Integer> freqWord2 = new HashMap<>();

        for(int i = 0;i<word1.length();i++){
            word1Set.add(word1.charAt(i));
            word2Set.add(word2.charAt(i));
            if (freqWord1.containsKey(word1.charAt(i))) {
                freqWord1.put(word1.charAt(i), freqWord1.get(word1.charAt(i)) + 1);
            }else{
                freqWord1.put(word1.charAt(i),  1);
            }
            if (freqWord2.containsKey(word2.charAt(i))) {
                freqWord2.put(word2.charAt(i), freqWord2.get(word2.charAt(i)) + 1);
            }else{
                freqWord2.put(word2.charAt(i),  1);
            }
        }
        if(word1Set.containsAll(word2Set) && word2Set.containsAll(word1Set) ){
                List<Integer> freqWord1List = new ArrayList<>(freqWord1.values());
                List<Integer> freqWord2List = new ArrayList<>(freqWord2.values());
                Collections.sort(freqWord1List);
                Collections.sort(freqWord2List);
                if( freqWord1List == freqWord2List ){
                    return true;
                }
            }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }
}
