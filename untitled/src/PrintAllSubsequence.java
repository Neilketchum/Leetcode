public class PrintAllSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        printSubsequence(str, "");
    }
    public static void printSubsequence(String str, String cur){
        if(str.length() == 0){
            System.out.println(cur);
            return;
        }
        printSubsequence(str.substring(1), cur + str.charAt(0));
        printSubsequence(str.substring(1), cur);


    }
}
