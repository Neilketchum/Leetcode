package SlidingWindow;

import java.util.ArrayList;
import java.util.Queue;

public class LongestOnes {
    public static int  longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int flip = 0;
        int left =0,right = 0; 
        while(right<nums.length)
        {
            if(nums[right]==0)
                flip++;

            if(flip>k)
            {
                if(nums[left]==0)
                    flip--;

                left++;
            }
            maxOnes = Math.max(maxOnes, right-left+1);
            right++;

        }

        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1}; 
        int k = 3;
        int currOnes = 0,maxOnes = 0,flips = k;
        int i = 0;
    
        int flag = -1;
        System.out.println(longestOnes(nums, k));
        while (  i < nums.length) {
            if(nums[i] == 1){
                currOnes++;
                maxOnes = Math.max(maxOnes, currOnes);
                i++;
            }
            else if(flips>0){
                flips--;
                if(flag == -1){
                    flag = i;
                }
                i++;
                currOnes++;
                maxOnes = Math.max(maxOnes, currOnes);  
            }
            else{
                flips = k;
                currOnes = 0;
                if(i == nums.length-1){
                    break;
                }
                  if(flag != -1)
                    i = flag+1;
                else
                    i++;
                flag = -1;
            }
        }
        System.out.println(maxOnes);
    }
}
