public class Solution303 {
    class NumArray {

        int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length];
            int temp = 0;
            for(int i=0;i<nums.length;i++){
                temp+=nums[i];
                sum[i] = temp;
            }
        }

        public int sumRange(int i, int j) {
            return sum[j] - sum[i-1];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
