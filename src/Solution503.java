import java.util.*;

public class Solution503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Stack<Integer> st = new Stack<>();//extends Vector一般不适用
            //用deque代替
            Deque<Integer> stack = new LinkedList<>();
            //stack.push();添加到队首
            int[] res = new int[n];
            Arrays.fill(res,-1);
            for(int i=0;i<2*(n);i++){
                if(st.isEmpty()) st.add(i%n);
                while(!st.isEmpty()&&nums[i%n]>nums[st.peek()]){
                    res[st.pop()]=nums[i%n];
                }
                st.add(i%n);
            }
            return res;
        }
    }
}
