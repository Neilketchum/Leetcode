import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BishuAndSoldiers {
    public static int getNearestSmallest(int[] soldierPowers,int n){
        int l = 0;
        int r = soldierPowers.length-1;
        while(l<r){
            int m = l + (r-l)/2;
            if(soldierPowers[m] == n){
                return m;
            }else if(soldierPowers[m] < n){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return l;
    }
    public static void processQueries(int[] soldierPowers, int[] bishuPowers,int q ) {
        int[] prefixSum = new int[soldierPowers.length];
        Arrays.sort(soldierPowers);
        prefixSum[0] = soldierPowers[0];
        for(int i = 1;i<soldierPowers.length;i++){
            prefixSum[i] = soldierPowers[i] + prefixSum[i-1];
        }
        for(int i = 0;i<q;i++){
            int totalSoldiersToKill = getNearestSmallest(soldierPowers,bishuPowers[i]);
            System.out.println(totalSoldiersToKill + 1 + " " + prefixSum[totalSoldiersToKill]);
        }



    }



      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of soldiers
        int n = sc.nextInt();
        int[] soldierPowers = new int[n];
        for (int i = 0; i < n; i++) {
            soldierPowers[i] = sc.nextInt();
        }

        // Read number of rounds
        int q = sc.nextInt();
        int[] bishuPowers = new int[q];
        for (int i = 0; i < q; i++) {
            bishuPowers[i] = sc.nextInt();
        }
        sc.close();

        processQueries(soldierPowers, bishuPowers, q);

    }
}
