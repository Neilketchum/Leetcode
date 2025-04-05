public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int pos= 0;
        int i = 0;
        while(i<nums.length){
            if(nums[i] == val){
                i++;
            }else{
                nums[pos] = nums[i];
                pos++;
                i++;
            }
        }
        return pos +1;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3,},3));
    }
}
