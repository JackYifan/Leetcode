import org.junit.Test;

import java.util.Arrays;

public class Solution338 {
    class Solution1 {
        public int countOne(int x){
            int cnt =0 ;
            while(x!=0){
                x = x&(x-1);
                cnt++;
            }
            return cnt;
        }
        public int[] countBits(int num) {
            int[]ans = new int[num+1];
            for(int i=0;i<=num;i++){
                ans[i] = countOne(i);
            }
            return ans;
        }
    }

    class Solution {
        public int[] countBits(int num) {
            int highBit = 0;
            int[] dp = new int[num+1];
            dp[0] = 0;
            for(int i=1;i<=num;i++){
                if((i&(i-1))==0){
                    //只有最高位是1
                    //而且在这之后的数的highBit会更新
                    highBit = i;
                }
                dp[i] = dp[i-highBit]+1;
            }
            return dp;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int[] ints = solution.countBits(5);
        System.out.println(Arrays.toString(ints));

    }
}
