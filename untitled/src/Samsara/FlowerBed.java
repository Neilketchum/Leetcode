package Samsara;

public class FlowerBed {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int counter = 0;
        int flower = 0;
        while (counter < flowerbed.length) {
            if (flower >= n)
                return true;
            // if (counter != flowerbed.length - 1 && flowerbed[counter] == 1) {
            //     counter = counter + 2;
            // }
            if (flowerbed[counter] == 0 && (counter == flowerbed.length - 1 ||flowerbed[counter + 1] == 0) && (counter == 0 || flowerbed[counter - 1] == 0)) {
                flower++;
                flowerbed[counter] = 1;
            }
            Math.mx(2,1);
            counter++;
        }
        if (flower >= n)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = { 0,1,0 };
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }
}
