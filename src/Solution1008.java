public class Solution1008 {
    class Solution {

        public TreeNode insert(TreeNode root,int x){
            if(root == null){
                return new TreeNode(x);
            }
            if(x<root.val) root.left = insert(root.left,x);
            if(x>root.val) root.right = insert(root.right,x);
            return root;
        }

        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = null;
            for(int i=0;i<preorder.length;i++){
                insert(root,preorder[i]);
            }
            return root;

        }
    }
}
