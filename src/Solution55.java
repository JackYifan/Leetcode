public class Solution55 {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int now = 0,end = 0;
            int max = 0;
            while(now<n){
                max = Math.max(max,now+nums[now]);
                if(max>=n-1){
                    return true;
                }
                if(now==end){
                    end = max;
                }
                now++;
            }
            return false ;

        }
    }
}
