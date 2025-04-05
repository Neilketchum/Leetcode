public class Combination {
    public static int getFactorial(int n){
        if( n == 1 || n == 0) return 1;
        return n * getFactorial(n-1);
    }

    public static int combination(int n ,int r){
        if(r == 0 || n == 0) return 1;
        return combination(n-1, r-1) + combination(n-1, r);
    }
    public static void main(String[] args) {
        System.out.println(combination(7, 2));
    }
}
