public class Solution45 {
    class Solution {
        public int jump(int[] nums) {
            int end = 0,now = 0; //end是当前step能到达的最远距离，如果now到达end需要更新end同时step++
            int max = 0;
            int n = nums.length;
            int step = 0;
            //当前step的end>n-1就能结束循环
            while(end<n-1){
                max = Math.max(max,now+nums[now]);
                if(now == end){
                    end = max;
                    step++;
                }
                now++;
            }
            return step;

        }
    }
}
