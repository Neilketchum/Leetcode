import java.util.HashMap;
import java.util.List;

public class RomanToInt {
  /*  For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
  The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead,
    the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine,
    which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer. */
    public static int romanToInt(String s) {
        int result = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        map.put('*',0);
        char[] charRomanNumber = s.toCharArray();
        for(int i = charRomanNumber.length - 1;i>= 0; i--){
            if(i>=1){
                if(charRomanNumber[i] == 'V' && charRomanNumber[i-1] == 'I'){
                    result += 4;
                    charRomanNumber[i-1] = '*';
                }
                else if(charRomanNumber[i] == 'X' && charRomanNumber[i-1] == 'I'){
                    result += 9;
                    charRomanNumber[i-1] = '*';
                }
                else if(charRomanNumber[i] == 'L' && charRomanNumber[i-1] == 'X'){
                    result += 40;
                    charRomanNumber[i-1] = '*';
                }
                else if(charRomanNumber[i] == 'C' && charRomanNumber[i-1] == 'X'){
                    result += 90;
                    charRomanNumber[i-1] = '*';
                }else if(charRomanNumber[i] == 'D' && charRomanNumber[i-1] == 'C'){
                    result += 400;
                    charRomanNumber[i-1] = '*';
                }
                else if(charRomanNumber[i] == 'M' && charRomanNumber[i-1] == 'C'){
                    result += 900;
                    charRomanNumber[i-1] = '*';
                }else{
                    result += map.get(charRomanNumber[i]);
                }
            }else{
                result += map.get(charRomanNumber[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
