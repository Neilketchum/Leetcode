public class LongestPallindromeSubstring {
    static String longestPalindrome(String s) {
        // code here
        int maxLength = 0;
        String result = "";
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            int count = 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    count+=2;
                    if (count > maxLength) {
                        result = s.substring(left, right + 1);
                    }
                    maxLength = Math.max(maxLength, count);
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("forgeeksskeegfor"));
    }

}
