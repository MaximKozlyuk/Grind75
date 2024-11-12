package leetcode.easy;

import java.util.ArrayList;

public class ReverseLinkedList {

    // Definition for singly-linked list.
    // cant change
    public static class ListNode {
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
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        var array = new ArrayList<Integer>();
        var currentNode = head;
        while (currentNode.next != null) {
            array.add(currentNode.val);
            currentNode = currentNode.next;
        }
        array.add(currentNode.val);

        var reverseCount = array.size() - 1;
        var reversedHead = new ListNode();
        var currentReversed = reversedHead;
        while (reverseCount > 0) {
            currentReversed.val = array.get(reverseCount);
            currentReversed.next = new ListNode();
            currentReversed = currentReversed.next;
            reverseCount--;
        }
        currentReversed.next = null;
        currentReversed.val = array.getFirst();
        return reversedHead;
    }

}
