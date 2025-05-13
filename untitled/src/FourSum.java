import java.util.*;
public class FourSum {
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<arr.length-3;i++){
                    if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicate i

            for(int j = i+1;j<arr.length-2;j++){
                            if (j > i + 1 && arr[j] == arr[j - 1]) continue; // skip duplicate j

                int start = j+1;
                int end = arr.length -1;
                                  int diff = target - (arr[i] + arr[j]);

                while(start<end){

                    if(arr[start]+arr[end] == diff){
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[start], arr[end])));
                        start++;
                        end--;
                          while (start < end && arr[start] == arr[start - 1]) start++;
                    while (start < end && arr[end] == arr[end + 1]) end--;
                    }else if(arr[start]+arr[end] > diff){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        // code here    
        return res;
    }
}
