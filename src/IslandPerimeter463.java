public class IslandPerimeter463 {
    static int islandPerimeterBrute(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0; // total boundaries

        // in order to find total boundaries, look for "water" and "out of bound" in 4 directions (up, down, left, right)

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                // water
                if(grid[i][j] == 0){
                    continue;
                }

                if(j+1>=n || grid[i][j+1]==0){
                    perimeter++;
                }

                if(j-1<0 || grid[i][j-1]==0){
                    perimeter++;
                }

                if(i+1>=m || grid[i+1][j]==0){
                    perimeter++;
                }

                if(i-1<0 || grid[i-1][j]==0){
                    perimeter++;
                }
            }
        }

        return perimeter;
    }

    static int m;
    static int n;
    static int perimeter;

    static void dfs(int[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0){
            perimeter++;
            return;
        }

        if(grid[i][j] == -1){
            return;
        }

        grid[i][j] = -1;

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
    static int islandPerimeterOptimal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        perimeter = 0;

        // in order to find total boundaries, look for "water" and "out of bound" in 4 directions (up, down, left, right)

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // got land
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    return perimeter;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        // Brute Force Approach
//        int ans1 = islandPerimeterBrute(grid);
//        System.out.println("Perimeter of island : "+ ans1);


        // Optimal Approach : DFS
        int ans2 = islandPerimeterOptimal(grid);
        System.out.println("Perimeter of island : "+ ans2);
    }
}
