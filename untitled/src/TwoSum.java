import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hmap = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            int comp = target - nums[i];
            if(hmap.containsKey(comp)){
                result[0] = hmap.get(comp);
                result[1] = i;
                return result;
            }else{
                hmap.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
       System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
