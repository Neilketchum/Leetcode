import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] list = new int[]{10,15,8,49,25,98,98,32,15};
        List<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(Integer i:list){
//            if(set.contains(i)){
//                System.out.println(i  + "  is repeated");
//            }else{
//                set.add(i);
//            }
            arrayList.add(i);
        }
        HashSet<Integer> set = arrayList.stream().map(n -> n)

    }
}
