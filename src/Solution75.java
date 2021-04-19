/**
 * @Author Yifan Wu
 * Date on 2021/4/19  12:56
 */
public class Solution75 {
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            //
            /**
             *  三个集合
             *  [0,left) ->0
             *  [left,i) ->1
             *  (right,n-1] ->2
             */
            //初始化集合为空
            int left = 0 ,i = left,right = n-1;
            //循环结束的条件是 [i,right]为空集合 i>right
            while(i<=right){
                if(nums[i]==0){
                    swap(nums,left,i);
                    left++; //left变动后2个集合都会改变
                    i++;
                }else if(nums[i]==1){
                    i++;
                }else{
                    swap(nums,i,right);
                    right--;
                }
            }
        }
        public void swap(int[]nums,int i,int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
