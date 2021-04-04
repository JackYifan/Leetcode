import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author Yifan Wu
 * Date on 2021/3/28  23:05
 */
public class Solution173 {
    class BSTIterator {
        TreeNode cur;
        Deque<TreeNode> stk;
        public BSTIterator(TreeNode root) {
            cur = root;
            stk = new LinkedList<TreeNode>();
        }

        public int next() {
            while(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }
            //此时cur==null 栈顶是左子树的最左结点
            cur = stk.poll();
            int ret = cur.val;
            cur = cur.right; //遍历右子树
            return ret;
        }

        public boolean hasNext() {
            return cur!=null||!stk.isEmpty();
        }
    }
}
