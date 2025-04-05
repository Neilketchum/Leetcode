public class CanPaceFlowers {
    public static  boolean canPlaceFlowers(int[] flowerbed, int n) {
        int totalPossibleFlowerBeds = 0;
        if(flowerbed.length == 1){
            if (flowerbed[0] == 0 && n<= 1){
                return true;
            }
        }
        for (int i = 0; i <flowerbed.length ; i++) {
            if(flowerbed[i] == 0){
                if(i == 0 && i+1 < flowerbed.length && flowerbed[i+1]==0){
                    flowerbed[i] = -1;
                    totalPossibleFlowerBeds ++;
                }
                else if(i == flowerbed.length-1 && i-1 >= 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = -1;
                    totalPossibleFlowerBeds ++;
                }
                if(i-1 >= 0 && i+1 < flowerbed.length && flowerbed[i-1]==0 && flowerbed[i+1]==0 ){
                    flowerbed[i] = -1;
                    totalPossibleFlowerBeds ++;
                }
            }
        }


        return totalPossibleFlowerBeds>=n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0},1));
       // System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},2));
    }
}
