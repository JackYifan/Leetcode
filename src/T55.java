public class T55 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE;
            int s = 0;//以当前遍历到的数字结尾的最大和
            for(int x:nums){
                if(s<=0) s = x;
                else s+=x;
                res = Math.max(res,s);
            }
            return res;
        }
    }
}
