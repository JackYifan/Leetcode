public class T72 {
    class Solution {
        public int getHeight(TreeNode root){
            if(root == null) return 0;
            return Math.max(getHeight(root.left),getHeight(root.right))+1;
        }
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;
            if(Math.abs(getHeight(root.left)-getHeight(root.right))>1) return false ;
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
}
