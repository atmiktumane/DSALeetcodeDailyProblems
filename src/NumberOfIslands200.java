public class NumberOfIslands200 {

    static int m;
    static int n;

    static void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0'){

            return;
        }

        if(grid[i][j] == '$'){
            return;
        }

        grid[i][j] = '$';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    static int numberOfIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int island = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // got land
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};

        int res = numberOfIslands(grid);

        System.out.println("Total no. of islands : "+ res);
    }
}
