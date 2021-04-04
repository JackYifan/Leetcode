import org.junit.Test;

public class T59 {
    class Solution1 {
        int res = 0;
        public void dfs(String s,int index){
            if(index==s.length()){
                res++;
                return ;
            }
            dfs(s,index+1);
            if(index+1<s.length()){
                String subString = s.substring(index,index+2);
                Integer x = Integer.valueOf(subString);
                if(x <=25&&x>=10){
                    dfs(s,index+2);
                }
            }
        }
        public int getTranslationCount(String s) {
            dfs(s,0);
            return res;
        }
    }
    class Solution {
        public int getTranslationCount(String s) {
            int[] dp = new int[s.length()+1]; //前index个数字翻译的版本数
            dp[0]=1;
            for(int i=1;i<=s.length();i++){
                dp[i] = dp[i-1];
                int t = 0;
                if(i>1){
                    t = (s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
                    if(t>=10&&t<=25) dp[i]+=dp[i-2];
                }
            }
            return dp[s.length()];

        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.getTranslationCount("12258");
        String s = "hello";
        String substring = s.substring(0, 2);
        System.out.println(substring);
    }
}
