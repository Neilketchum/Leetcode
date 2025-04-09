public class LongestRepeatingSubsequence {
    public static int lrs(String s) {
        // code here

        int[][] dp = new int[s.length()+1][s.length()+1];
    
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=s.length();j++){
                if(i == j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }else if(s.charAt(i-1) == s.charAt(j-1) && i != j){
                    dp[i][j] =  Math.max(dp[i-1][j-1]+1,Math.max(dp[i-1][j],dp[i][j-1]));
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[s.length()][s.length()];
    }
    public static void main(String[] args) {
        System.out.println(lrs("axxax"));
    }
}
