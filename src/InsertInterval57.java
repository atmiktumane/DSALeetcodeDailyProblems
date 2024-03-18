import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {
    static int[][] insertInterval(int[][] arr, int[] temp) {
        List<int[]> res = new ArrayList<>();

        for(int[] it : arr){
            if(it[1] < temp[0]){
                res.add(it);
            }
            else if((it[1] >= temp[0]) && (temp[1]>=it[0])){
                temp[0] = Math.min(temp[0], it[0]);
                temp[1] = Math.max(temp[1], it[1]);
            }
            else{
                res.add(temp);
                temp = it;
            }
        }
        res.add(temp);

        return res.toArray( new int[res.size()][]);

    }

    // convert 2d primitive array to 2d arraylist function
    public static ArrayList<ArrayList<Integer>> toArrayList2D(int[][] primitiveArray2D) {
        ArrayList<ArrayList<Integer>> arrayList2D = new ArrayList<>();
        for (int[] row : primitiveArray2D) {
            ArrayList<Integer> arrayListRow = new ArrayList<>();
            for (int num : row) {
                arrayListRow.add(num);
            }
            arrayList2D.add(arrayListRow);
        }
        return arrayList2D;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] num = {4,8};

        int[][] ans = insertInterval(intervals, num);

        // Convert 2D primitive array to 2D ArrayList
        ArrayList<ArrayList<Integer>> arrayList2D = toArrayList2D(ans);

        // Print the 2D ArrayList
        for (ArrayList<Integer> row : arrayList2D) {
            System.out.println(row);
        }

    }


}
