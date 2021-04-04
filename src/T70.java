
public class T70 {
    class Solution{
        int tot = 0;
        TreeNode res = null;
        public void dfs(TreeNode root,int k){
            if(root == null) return ;
            dfs(root.left,k);
            tot++;
            if(tot==k){
                res = root;
                return ;
            }

            dfs(root.right,k);

        }
        public TreeNode kthNode(TreeNode root, int k) {
            dfs(root,k);
            return res;
        }
    }
}
