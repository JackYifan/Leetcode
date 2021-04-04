import org.junit.Test;

public class Solution36 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] row = new int[9][10];
            int[][] col = new int[9][10];
            int[][] box = new int[9][10];
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]=='.') continue;
                    //判断每个位置是否合法
                    int x = board[i][j]-'0';
                    row[i][x]++;
                    col[j][x]++;
                    int boxNum = (i/3)*3+j/3;
                    box[boxNum][x]++;
                    if(row[i][x]>1||col[j][x]>1||box[boxNum][x]>1) return false;
                }
            }
            return true;
        }
    }


}
