public class Solution53 {
    class SolutionError {
        public int maxSubArray(int[] nums) {
            int left = 0,right = 0;
            int n = nums.length;
            int sum = 0;
            int max = Integer.MIN_VALUE;
            while(right<n){
                sum+=nums[right];
                while(left<right&&sum<max){
                    sum-=nums[left];
                    left++;
                }
                max = Math.max(max,sum);
                right++;
            }
            return max;
        }
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int[]dp = new int[n];
            dp[0]=nums[0];
            for(int i=1;i<n;i++){
                dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            }
            for(int i=0;i<n;i++){
                max = Math.max(max,dp[i]);
            }
            return max;
        }
    }
}
