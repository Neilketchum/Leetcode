import java.util.HashSet;
import java.util.Set;

public class MaxVowelsSubstring {
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;
        int maxVowelsinSubstring = 0;
        int maxVowels = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // Count vowels in the first window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                maxVowelsinSubstring++;
            }
        }
        maxVowels = maxVowelsinSubstring;

        // Check if the first window has all vowels
        if (maxVowelsinSubstring == k) {
            System.out.println(k);
        }

        // Slide the window over the string
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                maxVowelsinSubstring--;
            }
            if (vowels.contains(s.charAt(i))) {
                maxVowelsinSubstring++;
            }
            maxVowels = Math.max(maxVowels, maxVowelsinSubstring);

            // If a window with all vowels is found
            if (maxVowelsinSubstring == k) {
                System.out.println(k);
            }
        }
        System.out.println(maxVowels);
    }
}