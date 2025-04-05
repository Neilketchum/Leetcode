/**
 * ZigZag
 */
public class ZigZag {
    public static int[] solution(int[] numbers) {
        int[] result = new int[numbers.length -2];
        
        for(int i = 0;i<result.length;i++){
            if((numbers[i] < numbers[i+1] && numbers[i+1] > numbers[i+2])|| (numbers[i] > numbers[i+1] && numbers[i+1] < numbers[i+2])){
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }
        
        
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,1,3,4}));
    }
}