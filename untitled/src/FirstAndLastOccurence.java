import java.util.ArrayList;
import java.util.Arrays;

public class FirstAndLastOccurence {
    public static ArrayList<Integer>  search(int arr[], int key,int start,int end){
        int index = -1;
       while(start<=end){
             int mid = end + (start - end)/2;
             if(arr[mid] == key){
                index = mid;
                break;
             }else if(arr[mid] > key){
                 end = mid - 1;
             }else{
                 start = mid + 1;
             }
       }
       if(index == -1){
           return new ArrayList<Integer>(Arrays.asList(-1, -1));        

        }
       int firstOccurence = index;
       int lastOccurence = index;
       for(int i = index;i<arr.length;i++){
           if(arr[i] == key){
               lastOccurence = i;
           }else{
               break;
           }
       }
       for(int i = index;i>=0;i--){
            if(arr[i] == key){
               firstOccurence = i;
           }else{
               break;
           }
       }
       return new ArrayList<Integer>(Arrays.asList(firstOccurence, lastOccurence));        
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3,4,5,5,5,5,5,6,7,8,9,10},5,0,9));
    }
}
