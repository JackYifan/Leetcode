import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution227 {
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new LinkedList<>();
            int i=0;
            int n = s.length();
            int sign = 1;
            while(i<n){
                if(s.charAt(i)==' '){
                    i++;
                }else if(s.charAt(i)=='+'){
                    sign = 1;
                    i++;
                }else if(s.charAt(i)=='-'){
                    sign = -1;
                    i++;
                }else if(s.charAt(i)=='*'){
                    i++;
                    int x = 0;
                    while(s.charAt(i)==' ') i++;
                    while(i<n&&Character.isDigit(s.charAt(i))){
                        x = x*10+s.charAt(i)-'0';
                        i++;
                    }
                    Integer top = stack.pop();
                    stack.push(top*x);
                }else if(s.charAt(i)=='/'){
                    i++;
                    int x = 0;
                    while(s.charAt(i)==' ') i++;
                    while(i<n&&Character.isDigit(s.charAt(i))){
                        x = x*10+s.charAt(i)-'0';
                        i++;
                    }
                    Integer top = stack.pop();
                    stack.push(top/x);
                }else{
                    int x = 0;
                    while(i<n&&Character.isDigit(s.charAt(i))){
                        x = x*10+s.charAt(i)-'0';
                        i++;
                    }
                    stack.push(sign*x);
                }

            }
            int res = 0;
            while(!stack.isEmpty()){
                res += stack.pop();
            }
            return res;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int calculate = solution.calculate(" 3+5 / 2 ");
        System.out.println(calculate);
    }
}
