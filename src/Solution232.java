import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution232 {
    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new LinkedList<Integer>();
            outStack = new LinkedList<Integer>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }



    class MyQueue1 {

        Stack<Integer> st = null;
        /** Initialize your data structure here. */
        public MyQueue1() {
            st = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            st.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Stack<Integer> temp = new Stack<>();
            while(!st.isEmpty()){
                temp.add(st.pop());
            }
            int res = temp.pop();
            while(!temp.isEmpty()){
                st.add(temp.pop());
            }
            return res;
        }

        /** Get the front element. */
        public int peek() {
            Stack<Integer> temp = new Stack<>();
            while(!st.isEmpty()){
                temp.add(st.pop());
            }
            int res = temp.peek();
            while(!temp.isEmpty()){
                st.add(temp.pop());
            }
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return st.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
