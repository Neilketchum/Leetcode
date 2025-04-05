public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        if(s.isEmpty()){
            return true;
        }
        for(Character c:t.toCharArray()){
            if(s.charAt(i) == c){
                i++;
                if(i == s.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("","ahbgdc"));
    }
}
