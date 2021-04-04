import org.junit.Test;

public class Solution109 {
    class Solution1 {
        public ListNode findMid(ListNode start, ListNode end){
            ListNode fast = start,slow = start ;
            while(fast!=end&&fast.next!=end){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public TreeNode buildTree(ListNode start,ListNode end){
            if(start==end) return null;
            ListNode mid = findMid(start,end);
            TreeNode root = new TreeNode(mid.val);
            root.left = buildTree(start,mid);
            root.right = buildTree(mid.next,end);
            return root;
        }

        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head,null);
        }
    }
    //根据中序遍历构建二叉搜索树
    class Solution {
        ListNode head ;
        public int getLength(ListNode head){
            int cnt = 0;
            while(head != null){
                head = head.next;
                cnt++;
            }
            return cnt;
        }

        public TreeNode build(int left,int right){
            if(left>right) return null;
            TreeNode root = new TreeNode();
            int mid = (left+right)>>1;
            root.left = build(left,mid-1);
            root.val = head.val;
            head = head.next;
            root.right = build(mid+1,right);
            return root;
        }

        public TreeNode sortedListToBST(ListNode _head) {
            head = _head;
            int len = getLength(_head);
            return build(0,len-1);
        }
    }


    class SolutionError {
        public int getLength(ListNode head){
            int cnt = 0;
            while(head != null){
                head = head.next;
                cnt++;
            }
            return cnt;
        }
        //传引用也是局部变量，弹栈后消失，形参的地址变更不会影响实参
        //C++中ListNode*&head是指针引用，更改指针的地址会影响实参
        public TreeNode build(int left,int right,ListNode head){
            if(left>right) return null;
            TreeNode root = new TreeNode();
            int mid = (left+right)>>1;
            root.left = build(left,mid-1,head);
            root.val = head.val;
            head = head.next;
            root.right = build(mid+1,right,head);
            return root;
        }

        public TreeNode sortedListToBST(ListNode head) {
            int len = getLength(head);
            return build(0,len-1,head);
        }
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        SolutionError solution = new SolutionError();
        solution.sortedListToBST(node1);
    }



}
