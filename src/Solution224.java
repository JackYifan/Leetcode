import java.util.Deque;
import java.util.LinkedList;

public class Solution224 {
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new LinkedList<>();
            stack.push(1); //初始化正号
            int sign = 1;
            int res = 0;
            int n = s.length();
            int i = 0;
            while(i<n){
                char c = s.charAt(i);
                if(c==' '){
                    i++;
                }else if(c=='+'){
                    sign = stack.peek();
                    i++;
                }else if(c=='-'){
                    sign = -stack.peek();
                    i++;
                }else if(c=='('){
                    //括号内的数字都*sign,')'pop
                    stack.push(sign);
                    i++;
                }else if(c==')'){
                    stack.pop();
                    i++;
                }else{
                    //连续数字的处理
                    int x = 0;
                    while(i<n&&Character.isDigit(s.charAt(i))){
                        x = x*10+s.charAt(i)-'0';
                        i++;
                    }
                    res += x*stack.peek();
                }
            }
            return res;
        }
    }
}
