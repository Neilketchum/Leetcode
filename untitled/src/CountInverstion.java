public class CountInverstion {
    public static int countInversion(int[] arr){
     
        int inversionCount = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }
    public static void merge(int[] arr, int low, int mid, int high, int[] inversionCount){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i = 0;i<left.length;i++){
            left[i] = arr[low+i];
        }
        for(int j = 0;j<right.length;j++){
            right[j] = arr[mid+j+1];
        }
        int i = 0,j = 0 ,k = low;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
                inversionCount[0] += (n1 - i);  // Count inversions
            }
            k++;
        }
        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] arr, int low, int high, int[] inversionCount){
        if(low<high){
            int mid = low + (high - low)/2;
            mergeSort(arr,low,mid,inversionCount);
            mergeSort(arr,mid+1,high,inversionCount);
            merge(arr,low,mid,high,inversionCount);
        }
    }

    public static int mergeSortCountInversion(int[] arr){
        int[] inversionCount = {0};
        mergeSort(arr, 0, arr.length-1, inversionCount);
        return inversionCount[0];
    }

    public static void main(String[] args) {
        int[] arr ={2, 4, 1, 3, 5};
        System.out.println(mergeSortCountInversion(arr));
    }
}
