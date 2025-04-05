package SlidingWindow;

public class LongestSubArrayOfOnesAfterOneDeletion {
    public static void main(String[] args) {
        int[] nums= {1,1,0,1};
        int left = 0,right = 0,zeros = 0,maxOnes = 0;
        while(right<nums.length){
            if(nums[right] == 0){
                zeros++;
            }
            while(zeros>1){
                if(nums[left] == 0 ){
                   zeros--;
                }
                left++;
            }
            right++;
            maxOnes = Math.max(maxOnes, right-left);

        }
        System.out.println(maxOnes-1);
    }
}
