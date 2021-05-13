/**
 * @Author Yifan Wu
 * Date on 2021/5/11  22:37
 */
public class Solution1734 {
    class Solution {
        public int[] decode(int[] encoded) {
            int n = encoded.length+1; // n为j奇数
            //encoded[ans[0]^ans[1],ans[1]^ans[2],...,ans[n-2]^ans[n-1]]
            int tot = 1;
            for(int i=1;i<=n;i++){
                tot^=i;
            }
            //tot = 1^2^3^4...^n
            int t = 1;
            for(int i=0;i<=n-3;i+=2){
                t^=encoded[i];
            }
            int[] ans = new int[n];
            ans[n-1] = t^tot;
            /**
             * encoded[i]^ans[i+1] = ans[i]
             */
            for(int i=n-2;i>=0;i--){
                ans[i] = encoded[i]^ans[i+1];
            }
            return ans;
        }
    }
}
