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
    public boolean isPalindrome(ListNode head) {
        // find the middle and reverse the second half
        // if(head==null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firsthalf = head;
        ListNode secondhalf = reverse(slow);
        ListNode curr = secondhalf;
        while(curr!=null){
            if(firsthalf.val!=curr.val){
                return false;
            }
            firsthalf = firsthalf.next;
            curr = curr.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode middle){
        ListNode prev = null;
        ListNode curr = middle;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}