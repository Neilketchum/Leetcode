import java.util.Arrays;

public class AggresiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int max = stalls[stalls.length - 1];
        int min = stalls[0];
        int maxDistance = 0;
        while(min < max){
            int mid = min + (max - min)/2;
            if(canPlaceCow(stalls,k,mid)){
                maxDistance = mid;
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return maxDistance;
    }
    public static boolean canPlaceCow(int [] stalls,int cows,int minDifference){
        int cowCount = 1;
        int lastPosition = stalls[0];
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i] - lastPosition >= minDifference){
                cowCount++;
                lastPosition = stalls[i];
            }
            if(cowCount == cows){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.err.println(aggressiveCows(new int[]{106 ,113, 122, 0}, 2));
    }
}
 