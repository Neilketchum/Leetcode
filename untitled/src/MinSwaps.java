import java.util.*;

public class MinSwaps {

    static class Pair {
        int key;
        int val;

        Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        int getKey() {
            return this.key;
        }

        int getVal() {
            return this.val;
        }
    }

    public static int minSwaps(int[] arr) {
        int swap = 0;
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(new Pair(arr[i], i));
        }

        // Sort list by key (i.e., the array values)
        list.sort(Comparator.comparingInt(Pair::getKey));

        for (int i = 0; i < list.size(); i++) {
            Pair current = list.get(i);
            if (current.getVal() == i) {
                continue;
            }

            while (list.get(i).getVal() != i) {
                swap++;
                Collections.swap(list, i, list.get(i).getVal());
            }
        }

        return swap;
    }
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[] { 10, 19, 6, 3, 5 }));
    }
}
