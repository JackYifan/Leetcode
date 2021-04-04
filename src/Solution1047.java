import org.junit.Test;

public class Solution1047 {
    class Solution {
        public String removeDuplicates(String S) {
            StringBuffer stack = new StringBuffer();
            int top = -1; //栈顶指针的位置
            for(int i=0;i<S.length();i++){
                char ch = S.charAt(i);
                if(top>=0&&stack.charAt(top)==ch){
                    //消掉栈顶元素
                    stack.deleteCharAt(top);
                    --top;
                }else{
                    stack.append(ch);
                    ++top;
                }
            }
            return stack.toString();
        }
    }

    class SolutionError {
        public boolean hasBlock(String s){
            int n = s.length();
            for(int i=0;i<n-1;i++){
                if(s.charAt(i)==s.charAt(i+1)) return true ;
            }
            return false;
        }
        public String delete(String s){
            String res = "";
            int n = s.length();
            for(int i=0;i<n-1;i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    res = s.substring(0,i)+s.substring(i+2,n);
                    s.substring(i,i+2);
                    return res;
                }
            }
            return res;
        }


        public String removeDuplicates(String s) {
            while(hasBlock(s)){
                s = delete(s);
            }
            return s;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        solution.removeDuplicates("abbac");
    }
}
