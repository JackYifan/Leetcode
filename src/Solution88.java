/**
 * @Author Yifan Wu
 * Date on 2021/4/5  22:24
 */
public class Solution88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] sorted = new int[n+m];
            int p = 0,q = 0;
            int index = 0;
            while(p<m&&q<n){
                if(nums1[p]<nums2[q]) sorted[index++] = nums1[p++];
                else sorted[index++] = nums2[q++];
            }
            while(p!=m) sorted[index++] = nums1[p++];
            while(q!=n) sorted[index++] = nums2[q++];
            for(int i=0;i<n+m;i++){
                nums1[i] = sorted[i];
            }
        }
    }
}
