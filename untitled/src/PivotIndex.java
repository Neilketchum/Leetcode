import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {
      int sum  = 0;
      for (int i : nums) {
        sum+=i;
      }
      int leftSum = 0;
      for(int i = 0;i<nums.length;i++){
        if(leftSum * 2 == sum - nums[i]){
            return i;
        }
        leftSum += nums[i];
      }



      return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
        List<Integer> leftPrefix = new ArrayList<>();
        List<Integer> rightPrefix = new ArrayList<>();
        leftPrefix.add(0);
        rightPrefix.add(0);
        int i = 0,j = nums.length-1;

        while(i<nums.length -1 && j>0 ){
            leftPrefix.add(leftPrefix.get(leftPrefix.size() - 1) + nums[i] );
            rightPrefix.add(rightPrefix.get(rightPrefix.size()-1)+ nums[j]);
            i++;
            j--;
        }
        Collections.reverse(rightPrefix);
        i = 0;
       for(i = 0;i<leftPrefix.size();i++ ){
        if(leftPrefix.get(i) == rightPrefix.get(i)){
            System.out.println(i);
        }
       }
    }
}
