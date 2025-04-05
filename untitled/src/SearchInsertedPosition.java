import java.util.*;


/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

 */
public class SearchInsertedPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int mid = (low + high)/2;
        while(low<=high){
             mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(target>nums[mid]) return mid+1;


        return mid;
    }
    public static void main(String[] args) {
  //      System.out.println(searchInsert(new int[]{1,3,5,6},5));
  //      System.out.println(searchInsert(new int[]{1,3},2));
      System.out.println(searchInsert(new int[]{1,3,5,6},7));

    }
}
