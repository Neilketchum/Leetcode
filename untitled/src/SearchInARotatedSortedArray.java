public class SearchInARotatedSortedArray {
    public static int findPivot(int[] arr,int start,int end){
        
        while(start<=end){
            int mid = end + (start - end)/2;
            if(arr[mid] > arr[mid + 1] ){
               return mid;
            }else if(arr[mid] > arr[start]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
      }
      return -1;
    }
    public static int bs(int[] arr,int key,int start,int end){
        
        while(start<=end){
            int mid = end + (start - end)/2;
            if(arr[mid] ==  key ){
               return mid;
            }else if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
      }
      return -1;
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums,0 ,nums.length-1);
        if(target > nums[pivot]){
            return bs(nums,target,pivot,)
        }
    }


    public static void main(String[] args) {
            int pos = -1;
            System.out.println(findPivot(new int[]{4,5,6,7,0,1,2}, 0, 0, 6, pos));
    }
}
