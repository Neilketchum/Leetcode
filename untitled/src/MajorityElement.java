import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static List<Integer> majorityElement(int[] nums) {
        
        Integer element1 = null;
        Integer element2 = null;
        
        int count1 = 0;
        int count2 = 0;

        for(int num : nums){
            if(count1==0 && num!=element2){
                element1  =num;
            }else if(count2 == 0 && num!=element1){
                element2 = num;
            }
            if(num == element1){
                count1++;
            }else if(num == element2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(element1!=null){
            result.add(element1)
        }
        if(element2!=null){
            result.add(element2);
        }
      
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,3,3};
        System.out.println(majorityElement(nums));
    }
}
