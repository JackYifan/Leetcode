/**
 * @Author Yifan Wu
 * Date on 2021/3/25  22:54
 */
public class Solution82 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head==null) return null;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy; //pre永远是left前的元素
            ListNode left , right;
            left = head;right=left.next;
            while(left!=null&&right!=null){
                while(right!=null&&right.val==left.val) right = right.next;
                //此时right是null或者与left不同
                if(left.next!=right) {
                    //有重复元素
                    pre.next = right ;
                    left = right;
                    if(left!=null) right = left.next;
                }else{
                    //没有重复元素
                    pre = left;
                    left = right;
                    right = left.next;
                }
            }
            return dummy.next;
        }
    }
}
