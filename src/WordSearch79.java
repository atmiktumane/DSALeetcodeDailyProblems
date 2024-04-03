// Question : 79. Find whether word exists in given matrix or not
// TC : O(M*N) * exponential -> recursion is used
// SC : Auxiliary space

public class WordSearch79 {
    static int m, n;

    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    static boolean findFn(char[][] board, int i, int j, String word, int idx){
        if(idx == word.length()){
            return true;
        }

        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='$'){
            return false;
        }

        if(board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] row : dir){
            int new_i = i + row[0];
            int new_j = j + row[1];

            if(findFn(board, new_i, new_j, word, idx+1)){
                return true;
            }
        }

        board[i][j] = temp;

        return false;
    }

    static boolean wordExistInBoardFn(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0) && findFn(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "SEE";

        if(wordExistInBoardFn(board, word)){
            System.out.println("Yes, Word exists in given matrix board");
        }
        else{
            System.out.println("No, Word does not exist in given matrix board");
        }
    }
}
