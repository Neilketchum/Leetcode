package LoveBabbar;

public class Q8 {
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low;
        for(int j = low;j<high;j++){
            if(arr[j] <= pivot){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
    public static int quickSelect(int arr[], int low, int high, int K) {
        if(low == high){
            return arr[low];
        }        

        int pivot = partition(arr, low, high);
        if(K == pivot){
            return arr[pivot];
        } 
        else if(K < pivot){
            return quickSelect(arr,low,pivot-1,K);
        }else{
            return quickSelect(arr,pivot+1,high,K);
        }
    }
    static int kthSmallest(int arr[], int N, int K){
        
         return quickSelect(arr, 0, N - 1, K-1);
    }

    public static void main(String[] args) {
        
       int arr[] = {2, 3, 1, 20, 15}, K = 4 ;
       System.out.println(kthSmallest(arr, arr.length, K));
    }
    
}
