import org.junit.Test;

/**
 * @Author Yifan Wu
 * Date on 2021/5/12  18:40
 */
public class Solution1310 {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = arr.length;
            int[] pre = new int[n];
            pre[0] = arr[0];
            for(int i=1;i<n;i++){
                pre[i] = pre[i-1]^arr[i];
            }
            int[] ans = new int[queries.length];
            for(int i=0;i<queries.length;i++){
                int l = queries[i][0];
                int r = queries[i][1];
                if(l==0) ans[i] = pre[r];
                else ans[i] = pre[r]^pre[l-1];
            }
            return ans;
        }
    }
}
