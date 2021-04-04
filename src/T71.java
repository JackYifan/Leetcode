public class T71 {
    class Solution {
        int res = -1;
        public int dfs(TreeNode root){
            if(root==null) return 0;
            return Math.max(dfs(root.left),dfs(root.right))+1;
        }
        public int treeDepth(TreeNode root) {
            return dfs(root);
        }
    }
}
