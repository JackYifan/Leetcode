import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author Yifan Wu
 * Date on 2021/4/4  18:56
 */
public class Solution62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            m--;
            n--;
            BigDecimal[] f = new BigDecimal[n+m+1];
            f[0]=new BigDecimal(1);
            for(int i=1;i<n+m+1;i++){
                f[i] = f[i-1].multiply(new BigDecimal(i));
            }
            return (f[n+m].divide(f[n]).divide(f[m])).intValue();

        }
    }
    class Solution1 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m+1][n+1];
            dp[0][1]=1;
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
            return dp[m][n];
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.uniquePaths(10,10);
    }

}
