import java.util.Stack;
import java.util.stream.Collectors;

public class KEncodedStrings {
    public static int getNextClosedParenthesis(String s,int index){
        Stack<Character>st = new Stack<>();
        for(int i = index;i<s.length();i++){
            if(s.charAt(i) != ']'){
                st.add(s.charAt(i));
            }else{
                while(st.peek()!='['){
                    st.pop();
                }
                st.pop();
                if(st.empty()){
                    return i;
                }
            }
        }
        return  -1;
    }
    public static String decodeString(String s) {
        Stack<String>st = new Stack<>();
        int i = 0;
        while (i<s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int nearestClosedParanthesis = getNextClosedParenthesis(s, i+1);
                System.out.println(nearestClosedParanthesis);



                i = nearestClosedParanthesis;
            }
        }
       

        return st.stream().map(character -> character.toString()).collect(Collectors.joining(""));
    }
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]"));
    }
}
