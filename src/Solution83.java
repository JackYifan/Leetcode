/**
 * @Author Yifan Wu
 * Date on 2021/3/27  22:49
 */
public class Solution83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur = dummy;
            while(cur.next!=null){
                if(cur.next.val==cur.next.next.val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
}
