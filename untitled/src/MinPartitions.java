public class MinPartitions {
    public static int minPartitions(String n) {
        int max =Integer.MIN_VALUE;
        for(int i = 0;i<n.length();i++){
            max = Integer.max(max, Integer.parseInt(String.valueOf(n.charAt(i))));

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("82734"));
    }
}
