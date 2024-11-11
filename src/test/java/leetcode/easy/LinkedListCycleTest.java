package leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListCycleTest {

    @Test
    public void case1() {
        var pos0 = new LinkedListCycle.ListNode(3);
        var pos1 = new LinkedListCycle.ListNode(2);
        var pos2 = new LinkedListCycle.ListNode(0);
        var pos3 = new LinkedListCycle.ListNode(-4);
        pos0.next = pos1;
        pos1.next = pos2;
        pos2.next = pos3;
        pos3.next = pos1;
        assertTrue(new LinkedListCycle().hasCycle(pos0));
    }

    @Test
    public void twoNodesCase() {
        var pos0 = new LinkedListCycle.ListNode(1);
        var pos1 = new LinkedListCycle.ListNode(2);
        pos0.next = pos1;
        pos1.next = pos0;
        assertTrue(new LinkedListCycle().hasCycle(pos0));
    }

    @Test
    public void singleNodeCase() {
        var pos0 = new LinkedListCycle.ListNode(1);
        pos0.next = null;
        assertFalse(new LinkedListCycle().hasCycle(pos0));
    }

    @Test
    public void manyNodesNoCycle() {
        var pos0 = new LinkedListCycle.ListNode(3);
        var pos1 = new LinkedListCycle.ListNode(2);
        var pos2 = new LinkedListCycle.ListNode(0);
        var pos3 = new LinkedListCycle.ListNode(-4);
        pos0.next = pos1;
        pos1.next = pos2;
        pos2.next = pos3;
        pos3.next = null;
        assertFalse(new LinkedListCycle().hasCycle(pos0));
    }

}
