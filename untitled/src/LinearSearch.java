public class LinearSearch {
    // Method to perform linear search
    public static int linearSearch(int[] arr, int target) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // If the target is found, return the index
            if (arr[i] == target) {
                return i;
            }
        }
        // If the target is not found, return -1
        return -1;
    }
    public static void main(String[] args) {
        int[] numbers1 = {10, 22, 35, 40, 55};
        int target1 = 35;
        int result1 = linearSearch(numbers1, target1);
        if (result1 != -1) {
            System.out.println("Instance 1: Element " + target1 + " found at index: " + result1);
        } else {
            System.out.println("Instance 1: Element " + target1 + " not found in the array.");
        }
        int[] numbers2 = {7, 14, 21, 28, 35};
        int target2 = 50;
        int result2 = linearSearch(numbers2, target2);
        if (result2 != -1) {
            System.out.println("Instance 2: Element " + target2 + " found at index: " + result2);
        } else {
            System.out.println("Instance 2: Element " + target2 + " not found in the array.");
        }
    }
}
