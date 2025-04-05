public class MinJumps {
    public static int minJumps(int[] arr) {
        int far = 0;
        int jump = 0;
        for(int i =0;i<arr.length;i++){
            if(i > far){
                return -1;
            }
            if(far < arr[i] + i){
                jump++;
                far = arr[i] + i;
            }
            
            if(far >= arr.length -1){
                return jump;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
}