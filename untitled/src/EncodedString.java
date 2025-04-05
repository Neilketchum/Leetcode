import java.util.Stack;
public class EncodedString {
        public static String decodeString(String s) {
            Stack<String>stack = new Stack<>();
            for(Character c:s.toCharArray()){
                if(c == ']'){
                    String currentString = "";
                    while(!stack.peek().equals(String.valueOf('['))){
                        currentString = stack.pop() + currentString;
                    }
                    stack.pop();
                    String currentDigit = "";
                    while(stack.size()>0 && Character.isDigit(stack.peek().toCharArray()[0])){
                        System.out.println(stack.peek());
                        currentDigit = stack.pop() + currentDigit;
                    }
                    if(Integer.parseInt(currentDigit)>0){
                        // for(int i = 0;i<Integer.parseInt(currentDigit);i++){
                        //         currentString += currentString;
                        // }
                        currentString = new String(new char[Integer.parseInt(currentDigit)]).replace("\0", currentString);
                        stack.push(currentString);
                    }
                   
                }else{
                    stack.push(String.valueOf(c));
                }
            } 
                return String.join("", stack);      
        }
        public static void main(String[] args) {
            System.out.println(decodeString("3[a]2[bc]"));
        }
}
