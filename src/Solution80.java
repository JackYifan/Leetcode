import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Yifan Wu
 * Date on 2021/4/6  14:02
 */
public class Solution80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int left = 0 ,right = 0;
            int index = n-1;//指向最后一个元素
            while(left<n&&right<n){
                right = left;
                while(right<=index&&nums[left]==nums[right]) right++;
                //[left+1,right-2]被删除
                if(left+1<=right-2){
                    for(int i=left+1,j=right-1;j<=index;i++,j++){
                        nums[i] = nums[j];
                    }
                    index-=right-2-left ;
                }
                left++;
            }
            return index+1;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
    }
}
