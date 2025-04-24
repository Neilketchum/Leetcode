public class BuyAndSellStocks {

    public static int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for(Integer i : prices){
            if(i<lsf){
                lsf = i;
            }
            profit = Math.max(profit,i - lsf);
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }
}