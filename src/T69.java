public class T69 {
    class Solution {
        public int getNumberSameAsIndex(int[] nums) {
            int n = nums.length;
            int l = 0,r = n-1;
            while(l<r){
                int mid = (l+r+1)>>1;
                if(nums[mid]<=mid){
                    l = mid;
                }else{
                    r = mid - 1;
                }
            }
            if(nums[l]==l) return l;
            else return -1;
        }
    }
}
