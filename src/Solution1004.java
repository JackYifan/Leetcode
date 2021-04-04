public class Solution1004 {
    class Solution {
        public int longestOnes(int[] A, int K) {
            int n = A.length;
            int left = 0 , right = 0 ;
            int sum = 0 , res = 0 ;
            while(right<n){
                sum+=A[right];
                while((right-left+1)-sum>K){
                    sum-=A[left++];
                }
                // System.out.println(left);
                // System.out.println(right);
                // System.out.println(sum);
                res = Math.max(res,right-left+1);
                right++;
            }
            return  res;
        }
    }
}
