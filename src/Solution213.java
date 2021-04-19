import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/4/15  23:14
 */
public class Solution213 {
    class Solution {
        int n;
        public int rob(int[] nums) {
            n = nums.length;
            if(n==1) return nums[0];
            if(n==2) return Math.max(nums[0],nums[1]);

            return Math.max(maxSum(nums,0,n-2),maxSum(nums,1,n-1));
        }
        public int maxSum(int[]nums,int start,int end){
            int[] dp = new int[n]; //dp[i]表示[0:i] 最多的金额
            dp[start] = nums[start];
            dp[start+1] = Math.max(nums[start],nums[start+1]);
            for(int i=start+2;i<=end;i++){
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
            return dp[end];
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.rob(new int[]{1,2,3,1}
);
    }

}
