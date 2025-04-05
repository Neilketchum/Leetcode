public class HighestAltituide {
    public static void main(String[] args) {
        int[] gain = {52,-91,72};
        int maxHeight = 0;
        for(int i = 1;i<gain.length;i++){
            gain[i] = gain[i] + gain[i-1];
            maxHeight = Math.max(gain[i], maxHeight);
        }
        System.out.println(maxHeight);
    }
}
