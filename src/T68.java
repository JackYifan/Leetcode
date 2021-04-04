public class T68 {
    class Solution {
        public int getMissingNumber(int[] nums) {
            int n = nums.length;
            //[0-n] n+1个数字少1个
            int sum = n*(n+1)/2;
            for(int x:nums){
                sum-=x;
            }
            return sum;

        }
    }
}
