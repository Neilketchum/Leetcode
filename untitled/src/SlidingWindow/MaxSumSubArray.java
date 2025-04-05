package SlidingWindow;
import java.util.*;
public class MaxSumSubArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,12,-5,-6,50,3};
//        int k   = 4;
//        double slidingWindow = 0;
//        double maxAverage = 0;
//        for(int i =0;i<k;i++){
//            slidingWindow +=  nums[i];
//        }
//        maxAverage = slidingWindow;
//        for(int i = k;i<nums.length;i++){
//            slidingWindow += (nums[i] - nums[i-k]);
//            maxAverage = Double.max(slidingWindow,maxAverage);
//        }
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        // Split the input into parts
        String[] parts = input.split("&|=");

        // Extract num1 and num2 from the parts
        int num1 = Integer.parseInt(parts[0].trim());
        int num2 = Integer.parseInt(parts[2].trim());

        System.out.println(num1 + " " +  num2);
    }
    public static String mathChallenge(int num1, int num2) {
        if (num2 > num1) {
            // _define-ocg_: num2 is greater than num1, return true
            return "true";
        } else if (num1 == num2) {
            // _define-ocg_: num1 and num2 are equal, return -1
            return "-1";
        } else {
            // _define-ocg_: num2 is not greater than num1, return false
            return "false";
        }
    }
}
