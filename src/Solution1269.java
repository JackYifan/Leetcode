import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/5/13  11:35
 */
public class Solution1269 {
    class Solution1 {
        public int numWays(int steps, int arrLen) {
            final int mod = 1000000007;
            int upperBound = Math.min(steps,arrLen-1);
            int[][] dp = new int[steps+1][upperBound+1]; //走了i步，到达j位置的方法数
            //初始化
            dp[0][0]=1;
            //越界情况 0<=j<=min(steps,arrLen-1)
            //状态转移方程 dp[i][j] = dp[i-1][j-1]+dp[i-1][j+1]+dp[i-1][j]
            //在计算dp[i]时候，dp[i-1]的所有信息已经知道
            for(int i=1;i<=steps;i++){
                for(int j=0;j<=upperBound;j++){
                    dp[i][j] = dp[i-1][j];
                    if(j-1>=0){
                        dp[i][j] = (dp[i-1][j-1]+dp[i][j])%mod;
                    }
                    if(j+1<=upperBound){
                        dp[i][j] = (dp[i-1][j+1]+dp[i][j])%mod;
                    }
                }
            }
            return dp[steps][0];

        }
    }

    //空间优化,降维
    class Solution {
        public int numWays(int steps, int arrLen) {
            final int mod = 1000000007;
            int upperBound = Math.min(steps,arrLen-1);
            int[] dp = new int[upperBound+1]; //走了i步，到达j位置的方法数
            //初始化
            dp[0]=1;
            for(int i=1;i<=steps;i++){
                int[] next = new int[upperBound+1]; //用来计算下一组数据
                for(int j=0;j<=upperBound;j++){
                    next[j] = dp[j];
                    if(j-1>=0){
                        next[j] = (next[j]+dp[j-1])%mod;
                    }
                    if(j+1<=upperBound){
                        next[j] = (next[j]+dp[j+1])%mod;
                    }
                }
                dp = next; //dp保存上一组计算结果
            }
            return dp[0];

        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(solution.numWays(3, 2));
    }
}
