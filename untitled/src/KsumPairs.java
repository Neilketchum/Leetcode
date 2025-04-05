import java.util.HashMap;

public class KsumPairs {
    public static int maxOperations(int[] nums, int k) {
        int operation = 0;
        HashMap<Integer,Integer>frequencyMap = new HashMap<>();
        for(Integer num:nums){
            if(num < k){
                if(frequencyMap.containsKey(num)){
                    frequencyMap.put(num,frequencyMap.get(num) + 1);
                }else{
                    frequencyMap.put(num,1);
                }
            }

        }
        for(Integer num:nums){
            if( frequencyMap.containsKey(k - num) && frequencyMap.get(k - num) > 0 && frequencyMap.get(num)>0){
                if(num == k - num && frequencyMap.get(k - num) >= 2){
                    frequencyMap.put(k - num,frequencyMap.get(k - num) -2);
                    operation++;
                }else if(num != k - num ) {
                    frequencyMap.put(k - num,frequencyMap.get(k - num) -1);
                    frequencyMap.put(num,frequencyMap.get(num) -1);
                    operation++;
                }
            }
        }



        return operation;

    }
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{2,1,3,1,1,2,1,2,2,2,2},3));
    }
}
