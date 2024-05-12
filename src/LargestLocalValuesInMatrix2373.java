public class LargestLocalValuesInMatrix2373 {
    static int findMaxLocal(int[][] grid, int row, int col) {
        int maxi = 0;

        for (int i = row ; i < row+3 ; i++) {
            for (int j = col ; j < col+3 ; j++) {
                maxi = Math.max(maxi, grid[i][j]);
            }
        }

        return maxi;
    }

    static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n-2][n-2];

        for(int row=0; row<n-2; row++){ // TC: O(n^2)
            for(int col=0; col<n-2; col++){
                maxLocal[row][col] = findMaxLocal(grid, row, col); // TC: O(9)
            }
        }
        return maxLocal;


    }

    public static void main(String[] args) {
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};

        int[][] res = largestLocal(grid);

        // TC: O(n^2) ; SC: O(n^2)
        for(int i=0; i<res.length; i++){
            for(int j=0; j<res[0].length; j++){
                System.out.print(res[i][j] + " ");
            }System.out.println();
        }
    }
}
