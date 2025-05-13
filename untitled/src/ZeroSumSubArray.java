import java.util.HashMap;

public class ZeroSumSubArray {
    public static int findSubarray(int[] arr) {
        // code here.

        int res = 0;
        for(int i = 0;i<arr.length;i++){
            int currentSum = arr[i];
            if(currentSum == 0){
                System.out.println(i + " " + i);
            }
            for(int j = i+1;j<arr.length;j++){
                currentSum += arr[j];
                if(currentSum == 0){
                    System.out.println(i + " " + j);
                }
            }
        }
        return res;
    }
    public static int findSubarrayV2(int[] arr) {
        // code here.

        int res = 0;
        int[] prefixSum = new int[arr.length];
        HashMap<Integer,Integer>hash = new HashMap<>();
        hash.put(0, 1);
        for(int i = 0;i<arr.length;i++){
            prefixSum[i+1] = prefixSum[i] + arr[i];
            if(hash.containsKey(prefixSum[i+1])){
                res+= hash.get(prefixSum[i+1]);
                hash.put(prefixSum[i+1], hash.get(prefixSum[i+1])+1);
            }else{
                hash.put(prefixSum[i+1],1);
            }
        }
        
        return res;
    }
public static void main(String[] args) {
    System.out.println(findSubarray(new int[]{0, 0, 5, 5, 0, 0}));
}
}
