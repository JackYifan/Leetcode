import java.util.ArrayList;
import java.util.List;

public class Solution37 {
    class Solution {
        boolean[][]row = new boolean[9][9];
        boolean[][]col = new boolean[9][9];
        boolean[][][]box = new boolean[3][3][9];
        List<int[]> space = new ArrayList<>();
        boolean valid = false ;//标志是否已经有可行解
        public void dfs(char[][]board,int index){
            if(index==space.size()){
                valid = true;
                return ;
            }
            //取出坐标
            int[] point = space.get(index);
            int x = point[0], y = point[1];
            //遍历1-9
            for(int i=0;i<9&&!valid;i++){
                if(!row[x][i]&&!col[y][i]&&!box[x/3][y/3][i]){
                    //可以填入该数字
                    board[x][y]=(char)('0'+i+1);
                    row[x][i]=true;col[y][i]=true;box[x/3][y/3][i]=true;
                    dfs(board,index+1);
                    row[x][i]=false;col[y][i]=false;box[x/3][y/3][i]=false;
                }
            }

        }

        public void solveSudoku(char[][] board) {
            //将已知棋盘输入
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]=='.'){
                        space.add(new int[]{i,j});
                    }else{
                        int x = board[i][j]-'0'-1;
                        row[i][x]=true;
                        col[j][x]=true;
                        box[i/3][j/3][x]=true;
                    }
                }
            }
            dfs(board,0);

        }
    }
}
