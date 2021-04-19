import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/4/7  23:07
 */
public class Solution81 {
    class Solution {
        public boolean search(int[] nums, int target) {
            int n = nums.length;
            int left = 0 ,right = n-1;
            while(left<right){

                int mid = (left+right+1)>>1;
                if(nums[left]==nums[mid]&&nums[mid]==nums[right]){
                    left++;
                    right--;
                }else if(nums[mid]<=nums[right]){
                    //[mid,right] 单调
                    if(nums[mid]<=target&&nums[right]>=target){
                        left = mid;
                    }else{
                        right = mid-1;
                    }
                }else{
                    //[left,mid] 单调
                    if(nums[left]<=target&&target<nums[mid]){
                        right = mid-1;
                    }else{
                        left = mid;
                    }
                }

            }
            return nums[left]==target;
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.search(new int[]{1,3,1}
        ,2
);
    }
}
