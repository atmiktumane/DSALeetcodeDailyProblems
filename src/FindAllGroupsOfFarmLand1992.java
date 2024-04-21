import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmLand1992 {
    static int m;
    static int  n;

    static int bottom_i;
    static int bottom_j;

    static void dfs(int[][] land, int i, int j){
        if(i>=m || j>=n || land[i][j]==0){
            return;
        }

        if(land[i][j] == -1) return ;

        land[i][j] = -1;

        bottom_i = Math.max(bottom_i, i);
        bottom_j = Math.max(bottom_j, j);

        dfs(land, i+1, j);
        dfs(land, i, j+1);
    }

    // convert 2d List to 2d primitive array
    static int[][] convertToPrimitiveArray(List<List<Integer>> arrayList) {
        int[][] primitiveArray = new int[arrayList.size()][];
        for (int i = 0; i < arrayList.size(); i++) {
            List<Integer> row = arrayList.get(i);
            primitiveArray[i] = new int[row.size()];
            for (int j = 0; j < row.size(); j++) {
                primitiveArray[i][j] = row.get(j);
            }
        }
        return primitiveArray;
    }

    // main function
    static int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(land[i][j] == 1){
                    List<Integer> ds = new ArrayList<>();
                    ds.add(i);
                    ds.add(j);

                    bottom_i = i;
                    bottom_j = j;

                    dfs(land, i, j);

                    ds.add(bottom_i);
                    ds.add(bottom_j);

                    res.add(ds);
                }
            }
        }

        int[][]  ans= convertToPrimitiveArray(res);

        return ans;
    }


    public static void main(String[] args) {
//        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        int[][] land = {{1,1},{1,1}};

        int[][] res =  findFarmland(land);

//        System.out.println(res);
    }
}
