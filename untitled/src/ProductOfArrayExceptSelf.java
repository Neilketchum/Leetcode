/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.



        Example 1:

        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]
        Example 2:

        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf {
    private static int[] calculateProductExceptSelf(int[] preFix,int[] postFix,int[] nums){

        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                nums[0] = postFix[1];
            } else if (i == nums.length -1) {
                nums[i] = preFix[nums.length-2];
            }else{
                nums[i] = postFix[i+1] * preFix[i-1];
            }
        }

        return nums;
    }

    public static int[] productExceptSelf(int[] nums) {
       int[] prefixProduct = new int[nums.length];
       int[] postfixProduct = new int[nums.length];
       for(int i = 0;i<nums.length;i++){
           if(i == 0)
               prefixProduct[0] = nums[0];
           else
               prefixProduct[i] = nums[i] * prefixProduct[i-1];
       }
        for(int i = nums.length-1;i>=0;i--){
            if(i == nums.length-1)
                postfixProduct[nums.length-1] = nums[nums.length-1];
            else
                postfixProduct[i] = nums[i] * postfixProduct[i+1];
        }
        return calculateProductExceptSelf(prefixProduct,postfixProduct,nums);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
