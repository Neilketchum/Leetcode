public class ContainerWtihMostWater
{
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = Integer.MIN_VALUE;
        while(end > start){
            area = Math.max(Math.min(height[start],height[end]) * (end - start),area);
            if(height[start] > height[end]){
                end--;
            }else{
                start++;
            }
        }


        return area;

    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
