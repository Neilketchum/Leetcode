import java.util.ArrayList;
import java.util.Collection;


public class FactorialOfLargeNumber {
    
    public static ArrayList<Integer> factorial(int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int size = 1;
        result.add(1);
        for(int i = 1;i<=n;i++){
            int carry = 0;
            for(int j = 0 ;j<size;j++){
                int num = result.get(j)*i+carry;
                result.set(j,num%10);
                carry = num/10;
            }
            while(carry!=0){
                result.add(carry%10);
                size++;
                carry = carry/10;
            }
        }
       
        return Collections.reverse(result);
    }
    
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
