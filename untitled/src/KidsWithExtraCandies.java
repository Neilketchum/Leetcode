import java.util.ArrayList;
import java.util.List;

public class KidsWithExtraCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>res = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;
        for (int j : candies) {
            maxCandies = Math.max(maxCandies, j);
        }
        for (int candy : candies) res.add(candy + extraCandies >= maxCandies ? true : false);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3},3));
    }
}
