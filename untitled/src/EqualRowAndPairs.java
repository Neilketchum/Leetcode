import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EqualRowAndPairs {
    public static int equalPairs(int[][] grid) {
        HashMap<List<Integer>,Integer> rowSet = new HashMap<>();

        for (int[] row : grid) {
           List<Integer> rowList = Arrays.stream(row).boxed().collect(Collectors.toList());
           if(rowSet.containsKey(rowList)){
            rowSet.put(rowList, rowSet.get(rowList) + 1);
           }else{
            rowSet.put(rowList, 1);
           }
        }
        int colsize = grid[0].length;
        int totalPairs = 0;
        for(int j = 0;j<colsize;j++){
            List<Integer> colList = new ArrayList<>(); 
            for(int i = 0;i<colsize;i++){
                colList.add(grid[i][j]);
            }
            if(rowSet.containsKey(colList)){
                System.out.println(colList);
                totalPairs += rowSet.get(colList);
            }
        }
        return totalPairs;
    }
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }
}
