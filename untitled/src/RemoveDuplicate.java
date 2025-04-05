import java.util.Arrays;

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int pos = 0;
        int i = 1;
        while(i< nums.length){
            if(nums[i] == nums[pos]){
                i++;
            }else{
                pos++;
                nums[pos] = nums[i];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return pos+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
