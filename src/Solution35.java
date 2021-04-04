public class Solution35 {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            int left = 0 , right = n-1;
            while(left<right){
                int mid = (left+right)>>1;
                if(nums[mid]>=target)  right = mid;
                else left = mid +1;
            }
            return right;
        }
    }
}
