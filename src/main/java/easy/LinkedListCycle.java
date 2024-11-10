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
     * o(1) solution.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next.next == head) {
            return true;
        }
        var deletedNode = new ListNode(Integer.MIN_VALUE);

        var current = head.next;
        for (;;) {
            if (current == head) {
                return false;
            }
            if (current.next == null) {
                return false;
            }
            if (current.next == deletedNode) {
                return true;
            }
            var newCurrent = current.next;
            current.next = deletedNode;
            current = newCurrent;
        }
    }

}
