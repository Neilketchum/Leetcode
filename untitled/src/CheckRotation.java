public class CheckRotation {

    public static void main(String[] args) {
        String s = "abcde";
        for(int i = 0; i < s.length(); i++) {
            System.out.println(s.substring(i, s.length()) + s.substring(0, i));
        }
    }
}