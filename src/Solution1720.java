/**
 * @Author Yifan Wu
 * Date on 2021/5/6  21:55
 */
public class Solution1720 {
    class Solution {
        /**
         * encoded[i] = arr[i] ^ arr[i + 1]
         * encoded[i] ^ arr[i] = arr[i+1]
         */
        public int[] decode(int[] encoded, int first) {
            int n = encoded.length;
            int[]ans = new int[n+1];
            ans[0] = first;
            for(int i=1;i<=n;i++){
                ans[i] = ans[i-1] ^ encoded[i-1];
            }
            return ans;
        }
    }
}
