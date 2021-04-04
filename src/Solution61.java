/**
 * @Author Yifan Wu
 * Date on 2021/3/29  22:55
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode p = head;
        ListNode fast = head,slow = head;
        int n = 0;
        while(p!=null){
            n++;
            p=p.next;
        }
        k%=n;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
