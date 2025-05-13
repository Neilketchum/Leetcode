import java.util.Arrays;

public class BookAlocation {
    static int canDivide(int[] arr,int k,int maxPages){
        int flag = 0;
        int currentPages = 0;
        int hightPagesRead = -1;
        for(int i = 0;i <arr.length;i++){
            currentPages += arr[i];
            hightPagesRead = Math.max(hightPagesRead,currentPages);
            if(currentPages >= maxPages){
                currentPages = 0;
                flag++;
            }
            if(flag == k) {
                return hightPagesRead;
            }
        }
        return -1;
    }
    public static int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length){
            return -1;
        }
        // code here
        Arrays.sort(arr);
        int lastValue = 0;
        for(int i = arr[0] ; i< arr[arr.length - 1];i++){
            int largestPagesRead = canDivide(arr,k,i);
            if(largestPagesRead < 0 ){
                return lastValue;
            }else{
                if(largestPagesRead < 0)
                    lastValue = 0;
                else
                    lastValue = largestPagesRead;
            }
        }
        return lastValue;
    }
    public static void main(String[] args) {
        System.out.println(findPages(new int[]{15, 10, 19, 10, 5 ,18 ,7},5));
    }
}
