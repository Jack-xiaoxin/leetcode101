package twoPointers;

public class CycleLinkedList2 {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null) {
            fast = fast.next;
            if(fast == null) return null;
            fast = fast.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast == null || slow == null) return null;
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
