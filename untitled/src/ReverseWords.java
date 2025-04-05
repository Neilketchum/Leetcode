import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public static String reverseString(String input) {


    StringBuilder input1 = new StringBuilder();

    // append a string into StringBuilder input1
        input1.append(input);

    // reverse StringBuilder input1
        input1.reverse();
        return input1.toString();
}
    public static String reverseWords(String s) {
        String res  = "";
        String word = "";
        List<String> words = new ArrayList<>();
        for (int i = s.length()-1; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                if(!word.isEmpty()){
                   res += reverseString(word) + ' ';
                    word = "";
                }
            }else{
                word+=s.charAt(i);
            }
        }
        if(!word.isEmpty()){
            res += reverseString(word) ;
        }

        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
