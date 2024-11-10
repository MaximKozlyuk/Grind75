package easy;

public class LinkedListCycle {

    // Definition for singly-linked list.
    // cant change.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * https://leetcode.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        if (head.next == null) {
            return false;
        }

        var current = head.next;
        for (;;) {
            if (current == head) {
                return false;
            }
            if (current.next == null) {
                return true;
            }
            var newCurrent = current.next;
            current.next = null;
            current = newCurrent;
        }

    }

}
