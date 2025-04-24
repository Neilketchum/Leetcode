public class DuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(true){
            System.err.println(1);
            fast = nums[nums[fast]];
            slow  = nums[slow];
            if(fast == slow){
                break;
            }
        }
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
            System.out.println(2);
            if(slow == fast){
                return slow;
            }
        }


        return -1;


    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }
}