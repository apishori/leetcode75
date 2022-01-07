/*
Slow and fast pointer, fast moves 2 steps while slow is 1 step. If a cycle exists they will meet
otherwise fast will reach null
*/
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode slow = head, fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
