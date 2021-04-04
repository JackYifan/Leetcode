public class T67 {
    class Solution {
        /**
         * 二分查找K出现的左端和右端
         * @param nums
         * @param k
         * @return
         */
        public int getNumberOfK(int[] nums, int k) {
            if(nums.length==0) return 0;
            int left = findLeft(nums,k);
            int right = findRight(nums,k);
            // System.out.println(left);
            // System.out.println(right);
            if(left == -1) return 0 ;
            return right - left + 1;
        }

        public int findLeft(int[]nums,int k){
            int left = 0 , right = nums.length-1;
            while(left<right){
                int mid = left + right >> 1;
                if(nums[mid]>=k){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            if(nums[left]!=k) return -1 ;
            return left;
        }

        public int findRight(int[]nums,int k){
            int left = 0 , right = nums.length-1;
            while(left<right){
                int mid = (left + right + 1)>> 1;
                if(nums[mid]<=k){
                    left = mid;
                }else{
                    right = mid - 1;
                }
            }
            if(nums[left]!=k) return -1 ;
            return left;
        }
    }
}
