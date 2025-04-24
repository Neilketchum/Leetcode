import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonIn3Arrays {
     public static List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        int i= 0,j = 0,k = 0;
        int n1 = arr1.size(),n2 = arr2.size(),n3 = arr3.size();
        List<Integer> result = new ArrayList<>();
        
        while(i<n1 && j<n2 && k<n3){
            if(arr1.get(i) == arr2.get(j) && arr2.get(j) == arr3.get(k)){
                result.add(arr1.get(i));
                i++;
                j++;
                k++;
            }else if(arr1.get(i) <= arr2.get(j) && arr1.get(i) <= arr3.get(k)){
                i++;
            }else if(arr2.get(j) <= arr1.get(i) && arr2.get(j) <= arr3.get(k)){
                j++;
            }else{
                k++;
            }
        }
        return result;

        
    }
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 5, 10, 20, 40, 80));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(6, 7, 20, 80, 100));
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(3, 4, 15, 20, 30, 70, 80, 120));
        System.out.println(commonElements(arr1, arr2, arr3));
    }
}
