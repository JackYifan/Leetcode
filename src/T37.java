import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T37 {
    public class Codec {

        // Encodes a tree to a single string.

        public void dfs(TreeNode root,StringBuffer res){
            if(root == null){
                res.append("null,");
                return ;
            }
            res.append(root.val).append(',');
            dfs(root.left,res);
            dfs(root.right,res);
        }

        public String serialize(TreeNode root) {
            StringBuffer res = new StringBuffer();
            dfs(root,res);
            return res.toString();
        }
        public TreeNode dfs(List<String> list){
            if(list.get(0).equals("null")){
                list.remove(0);
                return null;
            }
            String s = list.get(0);
            TreeNode root = new TreeNode(Integer.parseInt(s));
            list.remove(0);
            root.left = dfs(list);
            root.right = dfs(list);
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
            TreeNode res = dfs(list);
            return res;
        }
    }

}
