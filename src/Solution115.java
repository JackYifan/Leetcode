/**
 * @Author Yifan Wu
 * Date on 2021/3/17  22:48
 */
public class Solution115 {
    class Solution {
        public int numDistinct(String s, String t) {
            int n = s.length();
            int m = t.length();
            if(n<m) return  0;
            //dp[i][j] 表示s[i:]中t[j:]的个数
            int[][] dp = new int[n+1][m+1];
            //初始化
            for(int i=0;i<=n;i++){
                //t[m:]是空字符串必然匹配一个
                dp[i][m] = 1;
            }
            for(int j=0;j<m;j++){
                //s[n:]是空字符串无匹配
                dp[n][j] = 0;
            }
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    if(s.charAt(i)==t.charAt(j)){
                        //分使用s[i]和t[j]和不使用的情况
                        dp[i][j] = dp[i+1][j+1]+dp[i+1][j];
                    }else{
                        dp[i][j] = dp[i+1][j];
                    }
                }
            }
            // for(int i=0;i<=n;i++){
            //     for(int j=0;j<=m;j++){
            //         System.out.print(dp[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            return dp[0][0];
        }
    }
}
