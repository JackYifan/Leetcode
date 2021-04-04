import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Solution32 {
    class Solution1 {
        public int longestValidParentheses(String s) {
            //栈顶元素记录的是成对括号的最左边序号-1
            Stack<Integer> st = new Stack<>();
            st.add(-1);
            int res = 0;
            int n = s.length();
            for(int i=0;i<n;i++){
                if(s.charAt(i)==')'){
                    st.pop();
                    if(st.empty()){
                        st.add(i);
                    }else{
                        res = Math.max(res,i-st.peek());
                    }
                }else{
                    st.add(i);
                }
            }
            return res;
        }
    }

    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            int[] dp = new int[n];//以i为结尾的最大匹配数
            int res = 0 ;
            for(int i=1;i<n;i++){
                if(s.charAt(i)==')'){
                    if(s.charAt(i-1)=='('){
                        dp[i]=2+(i-2>=0?dp[i-2]:0);
                        res = Math.max(res,dp[i]);
                    }else if(i-1-dp[i-1]>=0&&s.charAt(i-1-dp[i-1])=='('){
                        dp[i]=dp[i-1]+2+(i-2-dp[i-1]>=0?dp[i-2-dp[i-1]]:0);
                        res = Math.max(res,dp[i]);
                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
            return res;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int res = solution.longestValidParentheses("()(())");
        System.out.println(res);
    }
}
