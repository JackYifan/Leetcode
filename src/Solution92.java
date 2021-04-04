/**
 * @Author Yifan Wu
 * Date on 2021/3/18  22:38
 */
public class Solution92 {
    class Solution {
        public ListNode reverse(ListNode head){
            ListNode pre = null;
            ListNode cur = head;
            while(cur!=null){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            for(int i=0;i<m-1;i++) pre = pre.next;
            ListNode left = pre.next;
            ListNode right = pre;
            for(int i=0;i<n-m+1;i++) right = right.next;
            ListNode succ = right.next;
            //截断
            pre.next = null;
            right.next = null;
            reverse(left);
            pre.next = right;
            left.next = succ;
            return dummy.next;
        }
    }
}
