import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution107 {
    //在头部插入即可获得逆序
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if(root==null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                //此时在队列中的是同一层的
                List<Integer> level = new ArrayList<>();
                int size = q.size();
                for(int i=0;i<size;i++){
                    //一共poll出size个同一层的结点
                    TreeNode front = q.poll();
                    level.add(front.val);
                    if(front.left!=null) q.offer(front.left);
                    if(front.right!=null) q.offer(front.right);
                }
                ans.add(0,level);
            }
            return ans;
        }
    }
}
