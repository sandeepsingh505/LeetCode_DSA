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
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            arr.add(curr);
            curr = curr.next;
        }
        Collections.sort(arr,(a,b)-> a.val-b.val);
        ListNode newHead = arr.get(0);
        curr = newHead;
        for(int i = 1;i<arr.size();i++){
            curr.next = arr.get(i);
            curr = curr.next;
        }
        curr.next = null;
        return newHead;
        
    }
}