public class T60 {
    class Solution1 {
        int n,m;
        int res = 0;
        public void dfs(int x,int y,int t,int[][]grid){
            if(x>=n||y>=m) return ;
            if(x==n-1&&y==m-1){
                res = Math.max(res,t+grid[x][y]);
                return ;
            }
            t+=grid[x][y];
            dfs(x+1,y,t,grid);
            dfs(x,y+1,t,grid);
        }

        public int getMaxValue(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            dfs(0,0,0,grid);
            return res;
        }
    }

    class Solution {
        int n,m;
        public int getMaxValue(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            int[][]sum = new int[n+1][m+1];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    sum[i+1][j+1] = Math.max(sum[i][j+1],sum[i+1][j])+grid[i][j];
                }
            }
            return sum[n][m];

        }
    }

}
