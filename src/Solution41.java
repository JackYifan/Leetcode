public class Solution41 {
    //不使用额外空间的Hash表
    class Solution {
        public int firstMissingPositive(int[] nums) {
            //nums中的有效数字范围[1,n]
            int n = nums.length;
            //将所有负数更改为n+1
            for(int i=0;i<n;i++){
                if(nums[i]<=0) nums[i]=n+1;
            }
            for(int i=0;i<n;i++){
                if(Math.abs(nums[i])<=n){
                    nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
                }
            }
            for(int i=0;i<n;i++){
                // System.out.println(nums[i]);
                if(nums[i]>0){
                    return i+1;
                }
            }
            return n+1;
        }
    }
}
