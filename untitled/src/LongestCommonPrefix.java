public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i<strs.length;i++){
          minLength = Math.min(minLength, strs[i].length());
        }
        for(int i = 0;i<minLength;i++){
            Character character = strs[0].charAt(i);
            for(int j = 0 ;j<strs.length;j++){
                if(character != strs[j].charAt(i)){
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(strs[0].charAt(i));
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }
}
