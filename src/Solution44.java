import org.junit.Test;

import java.util.Arrays;

public class Solution44 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            boolean[][] dp = new boolean[n+1][m+1];
            //初始化dp数组
            dp[0][0]=true;
            for(int i=1;i<=m;i++){
                if(p.charAt(i-1)=='*') dp[0][i]=true; //前i个字符[0,i-1]
                else break;
            }
            //状态转移
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    char c = p.charAt(j-1);
                    if(c=='?') dp[i][j] = dp[i-1][j-1];
                    else if(c=='*') dp[i][j] = dp[i-1][j] | dp[i][j-1];
                    else dp[i][j] = dp[i-1][j-1] && c == s.charAt(i-1);
                }
            }
//            for(int i=0;i<n;i++){
//                System.out.println(Arrays.toString(dp[i]));
//            }

            return dp[n][m];

        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.isMatch("aa","*");
    }
}
