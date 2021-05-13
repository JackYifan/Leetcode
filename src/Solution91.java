import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/4/21  12:25
 */
public class Solution91 {
    //暴力解法超时
    class Solution1 {
        int res = 0;
        int n;
        public int numDecodings(String s) {
            n = s.length();
            dfs(s,0);
            return res;
        }
        public void dfs(String s,int index){
            if(index>n) return ;
            if(index==n) {
                res++;
                return ;
            }
            char c = s.charAt(index);
            if(c=='0') return;
            if(index+2<=n) {
                int x = (s.charAt(index)-'0')*10+s.charAt(index+1)-'0';
                if(x>=1&&x<=26) dfs(s,index+2);
            }
            dfs(s,index+1);

        }
    }
    class Solution {
        public int numDecodings(String s) {
            int n = s.length() ;
            int[]dp = new int[n+1]; //s[1:i] 的个数
            dp[0]=1;
            for(int i=1;i<=n;i++){
                if(s.charAt(i-1)!='0')
                    dp[i]+=dp[i-1];
                if(i>=2&&s.charAt(i-2)!='0'){
                    int x = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                    if(x>=1&&x<=26) dp[i]+=dp[i-2];
                }
            }
            return dp[n];
        }
    }
    @Test
    public void test(){
        new Solution().numDecodings("111111111111111111111111111111111111111111111"
        );
    }
}
