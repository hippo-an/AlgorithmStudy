package newstep.progression.leet;

import newstep.progression.leet.MergeTwoSortedLists_21_Easy.ListNode;

public class MiddleOfTheLinkedList_876_Easy {
    public ListNode middleNode(ListNode head) {
        ListNode loop = head;

        int ans = 0;
        while (loop != null) {
            ans++;
            loop = loop.next;
        }
        ans = ans / 2;
        while (ans > 0) {
            head = head.next;
            ans--;
        }

        return head;
    }

    /**
     * slow 보다 2배 빠른 fast pointer
     */
    public ListNode middleNodeCV(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
