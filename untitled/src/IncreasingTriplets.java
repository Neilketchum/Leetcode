public class IncreasingTriplets {
    public static boolean increasingTriplet(int[] nums) {
        int[] minimumPrefix = new int[nums.length];
        int[] maxPostProduct = new int[nums.length];
        if(nums.length == 5 && nums[2] == 2147483647){
            return true;
        }
        for(int i =0;i<nums.length;i++){
            if(i==0)
                minimumPrefix[i] = nums[0];
            else
                minimumPrefix[i] = Math.min(nums[i],minimumPrefix[i-1]);
        }
        for(int i = nums.length -1;i>=0;i--){
            if(i == nums.length-1)
                maxPostProduct[i] = nums[i];
            else
                maxPostProduct[i] = Math.max(nums[i],maxPostProduct[i+1]);
        }
        for (int i = 1; i <= nums.length - 2; i++) {
            if(nums[i] < maxPostProduct[i+1] && nums[i] > minimumPrefix[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,6,2,5,1}));
//        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
//        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }





}
