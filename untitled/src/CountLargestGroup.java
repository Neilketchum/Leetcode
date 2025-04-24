import java.util.*;

public class CountLargestGroup {
    public static int countDigitSum(int n){
        int temp = n;
        int sum = 0;
        while(temp>0){
            sum = sum+ temp%10;
            temp = temp/10;
        }
        return sum;
    }
    public static int countLargestGroup(int n) {
       HashMap<Integer,Integer> frequencyMap = new HashMap<>();
       for(int i = 0;i<=n;i++){
            int sumDigit = countDigitSum(i);
            if(frequencyMap.containsKey(sumDigit)){
                frequencyMap.put(sumDigit,frequencyMap.get(sumDigit)+1);
            }else{
                frequencyMap.put(sumDigit,1);
            }
       }
       int largestValue =  Collections.max(frequencyMap.values());
       int ans = 0;
       for(Integer i : frequencyMap.keySet()){
            if(frequencyMap.get(i) == largestValue){
                ans++;
            }
       }
       return ans;
    }
    public static void main(String[] args) {
        System.out.println(countLargestGroup(2));
    }
}
