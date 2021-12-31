/* 
traverse over both lists and add the lower value to a trav ListNode.
*/
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode trav = dummy;
        
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                trav.next = list1;
                list1 = list1.next;
            } else {
                trav.next = list2;
                list2 = list2.next;
            }
            trav = trav.next;
        }
        
        trav.next = list1 == null ? list2 : list1;
        
        return dummy.next;
    }
}