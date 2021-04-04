import java.util.Arrays;
import java.util.Comparator;

public class Solution354 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes.length == 0) return 0 ;
            int n = envelopes.length;
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]!=o2[0]) return o1[0]-o2[0];
                    return o2[1]-o1[1];
                }
            });
            int[]dp = new int[n+1];
            Arrays.fill(dp,1);
            int ans = 0;
            // dp[i] = max(dp[1-i-1])
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(envelopes[i][1]>envelopes[j][1]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
                ans = Math.max(dp[i],ans);
            }
            return ans;
        }
    }
}
