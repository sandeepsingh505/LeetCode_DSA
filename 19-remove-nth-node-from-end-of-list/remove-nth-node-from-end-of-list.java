class Solution{ 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        // Remove n nodes from stack
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        // Node before target
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
}