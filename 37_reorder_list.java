/*
Find middle of list (slow and fast pointer). Reverse second half of list (prev, curr, next pointers).
Merge two lists (first, second, fnext, snext pointers)
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

    public void reorderList(ListNode head) {
        // Find middle of the list
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half of list
        ListNode prev = null, next;
        while(slow != null) {
            next = slow.next;
            slow.next = prev;            
            prev = slow;
            slow = next;
        }
        
        // Merge two lists: head & prev
        ListNode first = head, second = prev;
        while(second.next != null) {
            next = first.next;
            first.next = second;
            first = next;
            
            prev = second.next;
            second.next = first;
            second = prev;
        }
    }
}