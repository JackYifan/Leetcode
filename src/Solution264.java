/**
 * @Author Yifan Wu
 * Date on 2021/4/12  14:54
 */
public class Solution264 {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] nums = new int[]{2,3,5};
            int[] dp = new int[n];
            dp[0] = 1;
            int p1=0,p2=0,p3=0;
            for(int i=1;i<n;i++){
                int num1 = dp[p1]*2;
                int num2 = dp[p2]*3;
                int num3 = dp[p3]*5;
                int num = Math.min(num1,Math.min(num2,num3));
                dp[i] = num;
                if(dp[i]==num1){
                    p1++;
                }
                if(dp[i]==num2){
                    p2++;
                }
                if(dp[i]==num3){
                    p3++;
                }
            }
            return dp[n-1];
        }
    }
}
