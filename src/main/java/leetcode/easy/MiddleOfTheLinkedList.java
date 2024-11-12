package leetcode.easy;

import java.util.ArrayList;

public class MiddleOfTheLinkedList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * https://leetcode.com/problems/middle-of-the-linked-list/
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        var array = new ArrayList<ListNode>();
        array.add(head);
        var current = head;
        while (current.next != null) {
            current = current.next;
            array.add(current);
        }
        return array.get(array.size() / 2);
    }

}
