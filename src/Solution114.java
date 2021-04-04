public class Solution114 {
    class Solution {
        public TreeNode flat(TreeNode root){
            if(root==null) return null;
            TreeNode leftList = flat(root.left);
            TreeNode rightList = flat(root.right);
            root.left = null;
            root.right = leftList;
            TreeNode p = root;
            while(p.right!=null){
                p=p.right;
            }

            p.right = rightList;
            return root;
        }

        public void flatten(TreeNode root) {
            flat(root);
        }
    }
}
