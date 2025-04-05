public class NeedleInHaystack {
    public static int strStr(String haystack, String needle) {
        int i =0;
        int j =0;
        if(needle.length() > haystack.length()){
            return -1;
        }
        while(i<haystack.length()){
            boolean found = false;
            if(haystack.charAt(i) == needle.charAt(0)){
                while(j<needle.length() && i+j < haystack.length()){
                    if(haystack.charAt(i + j)  == needle.charAt(j) ){
                        if(j == needle.length()-1){
                            found = true;
                            break;
                        }
                        j++;
                    }else{
                        break;
                    }
                }
            }
            if(found){
                return i;
            }
            i++;
        }
        return -1;
    }
    public static int strStrV2(String haystack, String needle) {
        int i =0;
        int k = 0;
        while(i<haystack.length()){
            if(k<i){
                k = i;
            }
            if(k<haystack.length() && k-i < needle.length() && haystack.charAt(k) == needle.charAt(k-i)){
                if(k-i == needle.length()-1){
                    return i;
                }
                k++;
            }else{
                i++;
                k = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStrV2("aaabaaabbbabaa","babb"));
    }

}
