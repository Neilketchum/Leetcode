import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurence {
    public static boolean uniqueOccurrences(int[] arr) {
       HashMap<Integer,Integer> frequencyHashMap = new HashMap<>();
       for (int i : arr) {
            if (frequencyHashMap.containsKey(i)) {
                frequencyHashMap.put(i, frequencyHashMap.get(i) + 1);
            }else{
                frequencyHashMap.put(i,  1);
            }
       }
       HashSet<Integer> st = new HashSet<>();
        for (Integer integer : frequencyHashMap.values()) {
            if(st.contains(integer)){
                return false;
            }
            st.add(integer);
        }
        return true;

   }
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
