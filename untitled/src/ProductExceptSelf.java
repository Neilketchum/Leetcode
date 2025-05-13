public class ProductExceptSelf {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int[] result = new int[arr.length];
        int[] prefix = new int[arr.length];
        int[] postfix = new int[arr.length];
        int start = 1;
        int end = 1;


        for(int i = 0;i<arr.length;i++){
            start *= arr[i];
            prefix[i] = start;

        }
        for(int i = arr.length-1;i>=0;i--){
            end *= arr[i];
            postfix[i] = end; 
        }
        for(int i = 0;i<arr.length;i++){
            if(i == 0){
                result[0] = postfix[i+1];
            }else if(i == arr.length -1){
                result[i] = prefix[i-1];
            }else{
                result[i] = prefix[i]*postfix[i+1];
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{10, 3, 5, 6, 2});
        for(Integer i:result){
            System.out.println(i);
        }
    }
    
}
