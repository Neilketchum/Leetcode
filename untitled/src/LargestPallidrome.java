public class LargestPallidrome {
    static boolean  isPallidrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static String lpa(String s) {
        int maxLength = 0;
        String result = "";
        for(int i = 0;i<s.length();i++){
            for(int j = s.length()-1;j>=i;j--){
                if(s.substring(i,j+1).length()   < maxLength){
                    break;
                }
                if(isPallidrome(s.substring(i,j+1))){
                    if(s.substring(i,j+1).length() > maxLength){
                        maxLength = s.substring(i,j+1).length();
                        result = s.substring(i,j+1);
                    }
                }
            }
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println(lpa("forgeeksskeegfor"));
    }
}