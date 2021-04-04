import java.util.HashMap;
import java.util.Map;

public class Solution106 {





    class Solution {

        int[] in;
        int[] post;
        Map<Integer,Integer> map = new HashMap<>();//用于存储in中的数字的位置


        public TreeNode build(int inl, int inr, int postl, int postr){
            if(inl>inr) return null;
            int root = post[postr];
            int index = map.get(root);
            TreeNode node = new TreeNode(root);
            if(inl==inr) return node; //此处剪枝运行时间大幅减小
            node.left = build(inl,index-1,postl,postl+index-inl-1);
            node.right = build(index+1,inr,postl+index-inl,postr-1);
            return node;

        }

        public TreeNode buildTree(int[] _inorder, int[] _postorder) {
            in =_inorder;
            post =_postorder;
            int n = in.length;
            for(int i=0;i<n;i++){
                map.put(in[i],i);
            }
            TreeNode root = build(0, n - 1, 0, n - 1);
            return root;

        }
    }
}
