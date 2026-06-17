/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // approach : length difference  method
        int lenA = length(headA);
        int lenB = length(headB);
        while(lenA > lenB){
            headA  = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!=null && headB!=null){
            if(headA==headB) {
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public int length(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
         return count;
    }
   
}