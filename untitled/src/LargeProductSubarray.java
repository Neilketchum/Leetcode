class LargeProductSubarray {
    public static int largestProduct(int[] arr) {
        int  i = 0;
        int j = arr.length - 1;
        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;
        while(i<arr.length && j>=0){
            if(arr[i] == 0){
                prefix *= 1;
            }else{
                prefix *= arr[i];
            }
            if(arr[j] == 0){
                suffix *= 1;
            }else{
                suffix *= arr[j];
            }
            
            maxProduct = Math.max(maxProduct, prefix );
            maxProduct = Math.max(maxProduct, suffix );
            i++;
            j--;
         
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        System.out.println(largestProduct(new int[]{-2, 6, -3, -10, 0, 2}));
    }
}