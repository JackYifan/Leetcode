import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Yifan Wu
 * Date on 2021/3/20  23:07
 */
public class Solution150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();
            for(String s:tokens){
                int x,y;
                switch(s){
                    case "+":
                        x = stack.poll();
                        y = stack.poll();
                        stack.push(x+y);
                        break;
                    case "-":
                        x = stack.poll();
                        y = stack.poll();
                        stack.push(x-y);
                        break;
                    case "*":
                        x = stack.poll();
                        y = stack.poll();
                        stack.push(x*y);
                        break;
                    case "/":
                        x = stack.poll();
                        y = stack.poll();
                        stack.push(x/y);
                        break;
                    default:
                        stack.push(Integer.valueOf(s));

                }
            }
            return stack.poll();
        }
    }
}
