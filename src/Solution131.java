import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution131 {
    class Solution {

        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>(); //相当于path用于存储当前路径
        int n;
        boolean[][] f;
        public List<List<String>> partition(String s) {
            n = s.length();
            //f[i][j] [i..j]是回文串
            f = new boolean[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(f[i],true);
            }
            for(int i=n-1;i>=0;i--){
                for(int j=i+1;j<n;j++){
                    f[i][j] = (s.charAt(i)==s.charAt(j))&&f[i+1][j-1];
                }
            }
            dfs(s,0);
            return res;
        }

        /**
         * [0,index-1]已经分割完毕放置在ans中,枚举所有[i,j]是回文串的进行dfs
         * @param s
         * @param index
         */
        public  void dfs(String s,int index){
            if(index==n){
                //n-1前的所有字符串已经分割完毕
                res.add(new ArrayList<>(ans));
            }
            for(int j=index;j<n;j++){
                if(f[index][j]){
                    //[i,j]
                    ans.add(s.substring(index,j+1));
                    dfs(s,j+1);
                    ans.remove(ans.size()-1);
                }
            }
        }
    }
}
