package Samsara;

public class GCDStrings {
    public static String gcdOfStrings(String str1, String str2) {
        String gcdString = "";
        int counter = 0;
        String largerString,smallerString ;
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return "";
        if(str1.length() < str2.length()){
            counter = str1.length();
            largerString = str1;
            smallerString = str2;
        }else{
            counter = str2.length();
            largerString = str1;
            smallerString = str2;
        }
        while (counter>0) {
            if(str1.replaceAll(smallerString.substring(0,counter), "").equals("") && str2.replaceAll(smallerString, "").equals("")){
                return smallerString.substring(0,counter);
            }else{
                counter--;
            }
        }
      
        return "";
    }
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }    
        
    }
    public static String gcdString(String str1,String str2){
        if(!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return "";
        String smallerString = "";   
        String largeString = ""; 
        if(str1.length() < str2.length()){
            smallerString = str2;
        }else{
            smallerString = str1;
        }
        int gcd = gcd(largeString.length(),smallerString.length());
        return largeString.substring(0, gcd);
    }
    public static void main(String[] args) {
        System.out.println(gcd(6, 4));
        System.out.println(gcdOfStrings("ABC", "FABCE"));   
    }
}