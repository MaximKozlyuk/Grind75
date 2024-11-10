package leetcode.easy;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    // cant modify!
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        var resultHead = checkEmptyCases(list1, list2);
        if (resultHead != null) {
            return resultHead;
        }

        resultHead = new ListNode();
        ListNode latestResult = resultHead;
        ListNode remainingToMerge;

        while (true) {
            if (list1.val < list2.val) {
                latestResult.val = list1.val;
                latestResult.next = new ListNode();
                latestResult = latestResult.next;
                list1 = list1.next;
                if (list1 == null) {
                    remainingToMerge = list2;
                    break;
                }
            } else if (list1.val == list2.val) {
                latestResult.val = list1.val;
                latestResult.next = new ListNode();
                latestResult = latestResult.next;
                list1 = list1.next;
                if (list1 == null) {
                    remainingToMerge = list2;
                    break;
                }
            } else {
                latestResult.val = list2.val;
                latestResult.next = new ListNode();
                latestResult = latestResult.next;
                list2 = list2.next;
                if (list2 == null) {
                    remainingToMerge = list1;
                    break;
                }
            }
        }

        while (true) {
            latestResult.val = remainingToMerge.val;
            remainingToMerge = remainingToMerge.next;
            if (remainingToMerge != null) {
                latestResult.next = new ListNode();
                latestResult = latestResult.next;
            } else {
                break;
            }
        }

        return resultHead;
    }

    private ListNode checkEmptyCases(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        return null;
    }

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/description/
     * @return Return the head of the merged linked list.
     *
     *  Попытка сделать оптимально, без инстанцирования новых объектов.
     */
    public ListNode mergeTwoLists_SMART_SOLUTION_TRY(ListNode list1, ListNode list2) {
        ListNode resultHead = checkEmptyCases(list1, list2);
        if (resultHead != null) {
            return resultHead;
        }

        ListNode toBeMerged;
        if (list1.val < list2.val) {
            resultHead = list1;
            toBeMerged = list2;
        } else if (list1.val == list2.val) {
            resultHead = list1;
            toBeMerged = list2;
        } else {
            resultHead = list2;
            toBeMerged = list1;
        }
        ListNode resultLatest = resultHead;

        // resultLatest.val <= toBeMerged.val
        while (true) {
            if (resultLatest.val <= toBeMerged.val) {
                resultLatest = resultLatest.next;
            } else {
                var beforeNext = resultLatest.next;
                var nextToBeMerged = toBeMerged.next;
                resultLatest.next = toBeMerged;
                toBeMerged.next = beforeNext;
                toBeMerged = nextToBeMerged;
            }

            // end conditions + actions
        }

        //return resultHead;
    }

}
