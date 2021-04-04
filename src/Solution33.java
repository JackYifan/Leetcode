public class Solution33 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0 ,right = n-1;
            while(left<=right){
                int mid = (left+right)>>1;
                if(nums[mid]==target) return mid;
                if(nums[mid]>=nums[0]){
                    if(nums[0]<=target&&target<nums[mid]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }else{
                    if(nums[mid]<target&&target<=nums[n-1]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
            return -1;

        }
    }

    class Solution1 {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0 ,right = n-1;
            while(left<right){
                int mid = (left+right)>>1;
                if(nums[mid]>=nums[0]){
                    if(nums[0]<=target&&target<=nums[mid]){
                        right = mid ;
                    }else{
                        left = mid + 1;
                    }
                }else{
                    if(nums[mid]>target||target>nums[n-1]){
                        right = mid;
                    }else{
                        left = mid;
                    }
                }
            }
            if(left==right) return left ;
            else return -1;

        }
    }

}
