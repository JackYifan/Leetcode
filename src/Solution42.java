import org.junit.Test;

public class Solution42 {
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int left = 0, right = n-1 ;
            int leftMax = 0;
            int rightMax = 0;
            int ans = 0;
            while (left < right) {
                if(height[left]<height[right]){
                    if(height[left]>leftMax){
                        leftMax=height[left];
                    }else{
                        ans += leftMax-height[left];
                    }
                    left++;
                }else {
                    if(height[right]>rightMax){
                        rightMax = height[right];
                    }else{
                        ans += rightMax-height[right];
                    }
                    right--;
                }

            }
            return ans;
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
