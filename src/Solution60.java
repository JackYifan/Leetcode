import java.util.Arrays;

/**
 * @Author Yifan Wu
 * Date on 2021/4/4  18:37
 */
public class Solution60 {
    class Solution {
        public String getPermutation(int n, int k) {
            int[]f = new int[n];
            f[0] = 1;
            for(int i=1;i<n;i++) f[i]=f[i-1]*i;
            k--; //编号从零开始方便整除和取余运算
            StringBuffer ans = new StringBuffer();
            int[] vis = new int[n+1]; //1-n
            Arrays.fill(vis,1);
            //选择第i位，已经选择了i-1个元素，剩余n-i+1个元素未选择,共f(n-i)种选法
            for(int i=1;i<=n;i++){
                int order = k/f[n-i]+1;
                for(int j=1;j<=n;j++){
                    //到第几个刚好减为0就选择
                    order-=vis[j];
                    if(order==0){
                        ans.append(j);
                        vis[j]=0; //已经选择
                        break;
                    }
                }
                k%=f[n-i];
            }
            return ans.toString();
        }
    }
}
