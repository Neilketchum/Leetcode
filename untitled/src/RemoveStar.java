import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveStar {
    public static String removeStars(String str) {
        Stack<Character> st = new Stack<>();
        for (Character character : str.toCharArray()) {
            if(character == '*'){
                st.pop();
            }else{
                st.add(character);
            }
        }
        return st.stream().map(s -> s.toString()).collect(Collectors.joining(""));
    }
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));        
    }
}
