import java.util.Arrays;

public class LargestConsequence {

     // Function to return length of longest subsequence of consecutive integers.
    public static int longestConsecutive(int[] arr) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int longest = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) { // start of a sequence
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
    return longest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(longestConsecutive(arr));
    }
}
