public class PathWithMaximumGold1219 {
    static int m, n;

    static int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}}; // directions : left, right, up, down

    static int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0){
            return 0; // 0 gold
        }

        int maxGold = 0;

        int originalGoldValue = grid[i][j];
        grid[i][j] = 0; // marked visited

        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            maxGold = Math.max(maxGold, dfs(grid, new_i, new_j));
        }
        maxGold = maxGold + originalGoldValue;

        grid[i][j] = originalGoldValue; // Backtracking

        return maxGold;
    }
    static int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int maxGold = 0;

        // TC: O(m*n) * O(4^(no. of gold possibilities))    ->  no. of gold possibilities we are calculating in dfs() with 4 possible directions
        // SC: O(m*n) -> recursion stack space since we are using dfs
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                maxGold = Math.max(maxGold, dfs(grid, i, j));
            }
        }

        return maxGold;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};

        // Optimal Solution : DFS ->  TC: O(m*n) * O(4^(no. of gold possibilities)) ; SC: O(m*n)
        int maxGoldAns = getMaximumGold(grid);
        System.out.println("Max. Gold : " + maxGoldAns);
    }
}
