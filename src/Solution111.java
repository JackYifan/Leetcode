import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    class Solution1 {
        int ans = Integer.MAX_VALUE;
        //到root的路径长度为depth
        public void dfs(TreeNode root,int depth){
            if(depth>ans) return ;
            if(root.left==null&&root.right==null){
                ans = Math.min(ans,depth);
                return ;
            }
            if(root.left!=null) dfs(root.left,depth+1);
            if(root.right!=null) dfs(root.right,depth+1);
        }

        public int minDepth(TreeNode root) {
            if(root==null) return 0;
            dfs(root,1);
            return ans;
        }
    }

    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            if(root.left==null&&root.right==null) return 1;
            int depth = 1;
            Queue<TreeNode>q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                depth++;
                //加入depth层的结点
                int size = q.size();
                //次数不能写成q.size因为q在循环中会动态变化
                for(int i=0;i<size;i++){
                    TreeNode front = q.poll();
                    if(front.left!=null) {
                        if(front.left.left==null&&front.left.right==null){
                            return depth;
                        }
                        q.add(front.left);
                    }
                    if(front.right!=null) {
                        if(front.right.left==null&&front.right.right==null){
                            return depth;
                        }
                        q.add(front.right);
                    }
                }

            }
            return 0;
        }
    }
}
