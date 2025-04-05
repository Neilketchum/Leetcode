public class GcdStrings {
    public static String gcdOfStrings(String str1, String str2) {
        int i = str1.length();
        int j = str2.length();
        for(int k = Math.min(i,j)-1;k>=0;k--){
            if(str1.replaceAll(str2.substring(0, k+1), "").isEmpty() && str2.replaceAll(str2.substring(0, k+1), "").isEmpty()){
                return str2.substring(0,k+1);
            }
        }
        return "";
    }
    public static void a(){
        throw new RuntimeException();

    }

    public static void main(String[] args) {

    }
}
