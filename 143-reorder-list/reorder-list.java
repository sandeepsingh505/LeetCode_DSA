/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // find middle and then reverse second half and then join alternatively
        if(head==null || head.next==null) return;
        ListNode slow = head;
        ListNode fast  = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second  = reverse(slow);
        ListNode first = head;
        while(second.next!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext; 
        }
    }
    public ListNode reverse(ListNode l1){
        ListNode prev = null;
        ListNode curr = l1;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}