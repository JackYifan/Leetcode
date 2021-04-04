import java.util.ArrayList;
import java.util.List;

public class T65 {
    class Solution {
        int n;

        /**
         * 归并排序，并返回[left,right]区间中的逆序对个数
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public int merge(int[]nums,int left,int right){
            if(left>=right) return 0;
            int mid = left+right>>1;
            int res = 0;
            //[left,mid] [mid+1,right]两个子区间中的逆序对总和
            res = merge(nums,left,mid) + merge(nums,mid+1,right);
            //归并排序并寻找跨越两个区间的逆序对个数
            int i = left,j = mid+1;
            List<Integer> list = new ArrayList<>();
            while(i<=mid&&j<=right){
                if(nums[i]<=nums[j]){
                    list.add(nums[i++]);
                }else{
                    //产生逆序对
                    res+=mid-i+1;
                    list.add(nums[j++]);
                }
            }
            while(i<=mid) list.add(nums[i++]);
            while(j<=right) list.add(nums[j++]);
            //将排序的[left,right]数组拷贝到原数组
            i = left;
            for(int x : list){
                nums[i++] = x;
            }
            return res;
        }

        public int inversePairs(int[] nums) {
            n = nums.length;
            return merge(nums,0,n-1);

        }
    }
}
