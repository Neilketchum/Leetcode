package Samsara;

import java.util.LinkedList;
import java.util.Queue;

public class IncTriplet {
    public static boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length <= 3 ){
            return false;
        }
        int minOne = nums[0];
        int minTwo = Integer.MAX_VALUE;
        Queue<Integer>q = new LinkedList<>();
        q.fr
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < minOne){
                minOne = nums[i];
            }
            if(nums[i] > minOne){
                minTwo = Math.min(minTwo,nums[i]);
            }
            if(nums[i] > minTwo){
                return true;
            }
        }
        

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,-2,-3};
        System.out.println(increasingTriplet(arr));
    }
}
