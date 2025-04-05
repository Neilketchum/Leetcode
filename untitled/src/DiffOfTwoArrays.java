import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * DiffOfTwoArrays
 */
public class DiffOfTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> setNums1 = new HashSet<>();
        HashSet<Integer> setNums2 = new HashSet<>();

        for(int n:nums1){
            setNums1.add(n);
        }
        for(int n:nums2){
            setNums2.add(n);
        }
        List<Integer> listnum1 = new  ArrayList<>();
        for(int n:setNums1){
           if(!setNums2.contains(n)){
            listnum1.add(n);
           }
        }
        result.add(listnum1);
        List<Integer> listnum2 = new  ArrayList<>();
        for(int n:setNums2){
           if(!setNums1.contains(n)){
            listnum2.add(n);
           }
        }
        result.add(listnum2);

        return result;

    }
    public static void main(String[] args) {
    System.out.println(findDifference(new int[]{1,2,3,3},new int[]{1,1,2,2})); 
    }
}