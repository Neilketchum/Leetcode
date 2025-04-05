public class StringCompression {
    public static int compress(char[] chars) {
        int counter = 0;
        char currentChar = chars[0];
        int currentGroup = 0;
        for(int i = 0;i<chars.length;i++){
             if(currentChar == chars[i]){
                currentGroup++;
            }else{
                if(currentGroup == 1){
                    chars[counter] = currentChar;
                    counter ++;
                }else{
                    char[] digits = ("" + currentGroup).toCharArray();
                    chars[counter] = currentChar;
                    counter ++;
                    for(Character digit:digits){
                        chars[counter] = digit;
                        counter++;
                    }
                }
                currentGroup = 1;
            }
            currentChar = chars[i];
        }
        if(currentGroup == 1){
            chars[counter] = currentChar;
            counter++;
        }else{
            char[] digits = ("" + currentGroup).toCharArray();
            chars[counter] = currentChar;
            counter ++;
            for(Character digit:digits){
                chars[counter] = digit;
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a'}));
    }
}
