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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            arr.add(curr);
            curr = curr.next;
        }
        // odd list add kr0 
        curr = head;
        for(int i = 0;i<arr.size();i+=2){
            curr.next = arr.get(i);
            curr = curr.next;
        }
        for(int i = 1;i<arr.size();i+=2){
            curr.next = arr.get(i);
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }
}