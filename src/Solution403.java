import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Yifan Wu
 * Date on 2021/4/30  13:03
 */
public class Solution403 {
    /**
     * 未优化的搜索超时
     */
    class Solution1 {
        int[] stones;
        Set<Integer> set = new HashSet<>();
        boolean flag = false;
        public boolean canCross(int[] _stones) {
            stones = _stones;
            for(int stone:stones){
                set.add(stone);
            }
            dfs(0,0);
            return flag;
        }

        /**
         *
         * @param preStep 上一次跳跃的距离
         * @param curPos 目前到达位置
         */
        public void dfs(int preStep,int curPos){
            if(curPos>stones[stones.length-1]) return;
            if(curPos==stones[stones.length-1]) {
                flag = true;
                return ;
            }
            for(int i=preStep-1;i<=preStep+1;i++){
                //遍历下一次能到达的位置
                if(i>0&&set.contains(curPos+i)) dfs(i,curPos+i);
            }

        }
    }

    /**
     * 动态规划
     */
    class Solution {
        boolean[][] dp; //[i][j] 表示目前在i号石子，上次j步
        Set<Integer> set = new TreeSet<>();
        public boolean canCross(int[] stones) {
            int n = stones.length;
            dp = new boolean[n][n];
            dp[0][0] = true;
            //剪枝
            for(int i=1;i<n;i++){
                if(stones[i]-stones[i-1]>i) return false ;
            }
            for(int i=1;i<n;i++){
                for(int j=i-1;j>=0;j--){
                    //从j跳跃到i,跳跃了k步
                    int k = stones[i]-stones[j];
                    if(k-1>j) break;
                    //跳跃k步到达dp[i][k]状态的三个状态
                    dp[i][k] = dp[j][k-1]||dp[j][k]||dp[j][k+1];
                    if(i==n-1&&dp[i][k]) return true;
                }
            }
            return false;
        }
    }

    /**
     * 记忆化搜索
     */
    class Solution2 {
        private Boolean[][] rec;

        public boolean canCross(int[] stones) {
            int n = stones.length;
            rec = new Boolean[n][n];
            return dfs(stones, 0, 0);
        }

        private boolean dfs(int[] stones, int i, int lastDis) {
            if (i == stones.length - 1) {
                return true;
            }
            if (rec[i][lastDis] != null) {
                return rec[i][lastDis];
            }

            for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
                if (curDis > 0) {
                    int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
                    if (j >= 0 && dfs(stones, j, curDis)) {
                        return rec[i][lastDis] = true;
                    }
                }
            }
            return rec[i][lastDis] = false;
        }
    }


}
