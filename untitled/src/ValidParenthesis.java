import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    Character openBracket = stack.pop();
                    if(c == '}' && openBracket != '{'){
                        return false;
                    }
                    if(c == ')' && openBracket != '('){
                        return false;
                    }
                    if(c == ']' && openBracket != '['){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{()}"));
    }
}
