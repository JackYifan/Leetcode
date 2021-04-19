import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/4/8  11:13
 */
public class Solution153 {
    /**
     * 寻找的数字具有的特征是nums[i]<nums[i-1]&&nums[i]<nums[i+1]
     */
    class Solution1 {
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0,right = n -1;
            while(left<right){
                int mid = (left+right)>>1;
                if(nums[mid]<nums[right]) right = mid;
                else left = mid+1;
            }
            return nums[left];
        }
    }
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0,right = n -1;
            if(nums[0]<nums[n-1]) return nums[0];
            while(left<right){
                int mid = (left+right)>>1;
                if(nums[mid]<nums[0]&&nums[mid]<nums[n-1]) right = mid;
                else left = mid+1;
            }
            return nums[left];
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.findMin(new int[]{11,13,15,17});

    }
}
