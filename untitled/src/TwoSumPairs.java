import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumPairs {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){

            if(arr[i] == 0){
                if(map.containsKey(0)){
                    pairs.add(new ArrayList<>(Arrays.asList(0,0)));
                    map.remove(0);
                }else{
                    map.put(0,1);
                }
            }else if(map.containsKey(-arr[i])){
                pairs.add(new ArrayList<>(Arrays.asList(-arr[i],arr[i])));
                map.put(-arr[i],map.get(-arr[i]) - 1);
            }else{
                map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
            }
           
        }
        pairs.sort((a,b)-> a.get(0) - b.get(0));
        return pairs;
    }
    public static void main(String[] args) {
        int[] arr ={6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        System.out.println(getPairs(arr));
    }
}
