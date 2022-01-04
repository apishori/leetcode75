/*
divide and conquer: merge set of 2 lists using 08 algorithm until 1 left
*/
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int delta = 1;
        while(delta < lists.length) {
            for(int i = 0; i < lists.length - delta; i += 2 * delta) {
                lists[i] = merge2Lists(lists[i], lists[i + delta]);
            }
            delta *= 2;
        }
        return lists[0];
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode trav = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                trav.next = l1;
                l1 = l1.next;
            } else {
                trav.next = l2;
                l2 = l2.next;
            }
            trav = trav.next;
        }
        trav.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
