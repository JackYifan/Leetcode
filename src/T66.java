public class T66 {
    class Solution {
        public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while(p!=q){

                p = p.next;
                q = q.next;
                if(p==null){
                    p = headB;
                }
                if(q==null){
                    q = headA;
                }
            }
            return p;
        }
    }
}
