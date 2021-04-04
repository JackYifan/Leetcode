import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class Solution132 {
    class Solution {
        public int minCut(String s) {
            //g[i][j] 表示[i..j]是回文串
            int n = s.length();
            boolean[][]g = new boolean[n][n];
            //初始化二维数组
            for(int i=0;i<g.length;i++){
                Arrays.fill(g[i],true);
            }

            //保证在转移方程中的右边中的所有值都已经被计算过
            for(int i=n-1;i>=0;i--){
                for(int j=i+1;j<n;j++){
                    g[i][j] = (s.charAt(i)==s.charAt(j))&&g[i+1][j-1];
                }
            }

            int[]f = new int[n]; //p[0..i]分割的最少次数
            // [j+1,i]是回文串,f[i]=f[j]+1 j in range(0,i-1)
            Arrays.fill(f,Integer.MAX_VALUE);

            for(int i=0;i<n;i++){
                if(g[0][i]){
                    //初始化dp
                    f[i] = 0;//不用分割
                }else{
                    for(int j=0;j<i;j++){
                        if(g[j+1][i]){
                            f[i] = Math.min(f[i],f[j]+1);
                        }
                    }
                }

            }

            return f[n-1];
        }
    }
    @Test
    public void test(){
        Solution solution = new Solution();
        solution.minCut("aab");
    }

}
