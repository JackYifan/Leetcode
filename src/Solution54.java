import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    class Solution {
        int n,m;
        boolean[][] vis;
        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix==null) return null;
            int[]dx = new int[]{1,0,-1,0};
            int[]dy = new int[]{0,1,0,-1};
            int direction = 0 ;
            n = matrix.length;
            m = matrix[0].length;
            vis = new boolean[n][m];
            int x=0;int y = 0;
            List<Integer>res = new ArrayList<>();
            while(res.size()<n*m){
                res.add(matrix[y][x]);
                vis[y][x]=true;
                if(!isValid(x+dx[direction],y+dy[direction])){
                    direction = (direction+1)%4;
                }
                x=x+dx[direction];
                y=y+dy[direction];
            }
            return res;
        }

        public boolean isValid(int x,int y){
            if(x<0||x>=m||y<0||y>=n||vis[y][x]) return false ;
            return true;
        }
    }




    class Solution2 {
        public List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = matrix.length;
            int m = matrix[0].length;
            int x0=0,y0=0,x1=n-1,y1=m-1;
            while(x0<=x1&&y0<=y1){
                for(int i=y0;i<=y1;i++){
                    list.add(matrix[x0][i]);
                }
                for(int i=x0+1;i<=x1-1;i++){
                    list.add(matrix[i][y1]);
                }
                if(x0!=x1){
                    for(int i=y1;i>=y0;i--){
                        list.add(matrix[x1][i]);
                    }
                }

                if(y0!=y1){
                    for(int i=x1-1;i>=x0+1;i--){
                        list.add(matrix[i][y0]);
                    }
                }

                x0++;y0++;x1--;y1--;
            }
            return list;

        }
    }

    class Solution1 {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                order.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                column += directions[directionIndex][1];
            }
            return order;
        }
    }

}
