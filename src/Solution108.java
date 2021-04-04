public class Solution108 {
    class Solution {
        public TreeNode buildBST(int[]nums,int left,int right){
            if(left>right) return null;
            int mid = (left+right)>>1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBST(nums,left,mid-1);
            root.right = buildBST(nums,mid+1,right);
            return root;
        }
        public TreeNode sortedArrayToBST(int[] nums) {
            //构造整个二叉树而构造左子树的方法是一样的，所以采用递归
            int n = nums.length;
            TreeNode root = buildBST(nums,0,n-1);
            return root;
        }
    }
}
