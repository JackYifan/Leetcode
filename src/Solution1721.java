/**
 * @Author Yifan Wu
 * Date on 2021/4/2  20:30
 */
public class Solution1721 {
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int left = 0 ,right = n-1;
            int leftMax = 0,rightMax = 0;
            int res = 0;
            while(left<right){
                leftMax = Math.max(leftMax,height[left]);
                rightMax = Math.max(rightMax,height[right]);
                if(height[left]<height[right]) {
                    res+=leftMax-height[left];
                    left++;
                }else {
                    res+=rightMax-height[right];
                    right--;
                }
            }
            return res;
        }
    }
}
