import java.util.List;

/**
 * @Author Yifan Wu
 * Date on 2021/3/21  9:06
 */
public class Solution73 {

    class Solution {
        public void setZeroes(int[][] matrix) {
            int n,m;
            if(matrix==null) return ;
            n = matrix.length;
            m = matrix[0].length;
            boolean flagRow0 = false;
            boolean flagCol0 = false;
            for(int i=0;i<n;i++){
                if(matrix[i][0]==0){
                    flagCol0 =true;
                }
            }
            for(int j=0;j<m;j++){
                if(matrix[0][j]==0){
                    flagRow0 = true;
                }
            }

            //第一行和第一列标记该行或者列需要置零
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    if(matrix[i][j]==0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for(int i=1;i<n;i++){
                if(matrix[i][0]==0){
                    for(int j=0;j<m;j++){
                        matrix[i][j] = 0;
                    }
                }
            }

            for(int j=1;j<m;j++){
                if(matrix[0][j]==0){
                    for(int i=0;i<n;i++){
                        matrix[i][j] = 0;
                    }
                }
            }
            if(flagRow0){
                for(int j=0;j<m;j++){
                    matrix[0][j] = 0;
                }
            }
            if(flagCol0){
                for(int i=0;i<n;i++){
                    matrix[i][0] = 0;
                }
            }
        }
    }


    class Solution1 {
        int n,m;
        public void setZeroes(int[][] matrix) {
            if(matrix==null) return ;
            n = matrix.length;
            m = matrix[0].length;
            int[] x = new int[n];
            int[] y = new int[m];
            int index = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j]==0){
                        x[index]=i;
                        y[index]=j;
                        index++;
                    }
                }
            }
            for(int i=0;i<index;i++){
                change(matrix,x[i],y[i]);
            }
        }
        public void change(int[][]matrix,int x,int y){
            for(int j=0;j<m;j++){
                matrix[x][j]=0;
            }
            for(int i=0;i<n;i++){
                matrix[i][y]=0;
            }
        }
    }
}
