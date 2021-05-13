/**
 * @Author Yifan Wu
 * Date on 2021/4/30  12:26
 */
public class Solution897 {
    class Solution {
        TreeNode cur;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy = new TreeNode(-1);
            cur = dummy;
            dfs(root);
            return dummy.right;
        }
        public void dfs(TreeNode root){
            if(root==null) return ;
            dfs(root.left);
            root.left=null;
            cur.right=root;
            cur = cur.right;
            dfs(root.right);
        }
    }
}
