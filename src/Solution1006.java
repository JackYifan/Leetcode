import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Yifan Wu
 * Date on 2021/4/1  23:13
 */
public class Solution1006 {
    class Solution {
        public int clumsy(int N) {
            Deque<Integer> stk = new LinkedList<>();
            String[] op = new String[]{"*","/","+","-"};
            int index=0;
            stk.push(N);
            N--;
            while(N>0){
                switch (op[index%4]){
                    case "*":
                        stk.push(stk.poll()*N);
                        N--;
                        break;
                    case "/":
                        stk.push(stk.poll()/N);
                        N--;
                        break;
                    case "+":
                        stk.push(N);
                        N--;
                        break;
                    case "-":
                        stk.push(-N);
                        N--;
                        break;

                }
                index++;
            }
            int res = 0;
            while(!stk.isEmpty()){
                res+=stk.poll();
            }
            return res ;
        }
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        int clumsy = solution.clumsy(10);
        System.out.println(clumsy);
    }
}
