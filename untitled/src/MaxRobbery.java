public class MaxRobbery {
    public static int findMaxSum(int arr[]) {
        // code here
        int maxSum = 0;
        for(int i = 1;i<arr.length;i++){
           if(i == 1){
                arr[i] = Math.max(arr[0],arr[1]);
           }else{
                arr[i] = Math.max(arr[i-2]+arr[i],arr[i-1]);
           }
        }
        return Math.max(arr[arr.length-1], arr[arr.length-2]);
    }
    public static void main(String[] args) {
       System.out.println(findMaxSum(new int[]{6,5,5,7,4})); 
    }
}
