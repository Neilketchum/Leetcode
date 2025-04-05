public class MaxAverageSubArray {
    public static double findMaxAverage(int[] nums, int k) {
        double average =Double.NEGATIVE_INFINITY;
        for(int i =0;i<= nums.length-k;i++){
            double sum = 0;
            for(int j = i;j<Math.min(i+k,nums.length);j++){
                sum += nums[j];
            }
            average = Double.max(average,sum/k);
        }
        return average;
    }
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1},1));
    }
}
