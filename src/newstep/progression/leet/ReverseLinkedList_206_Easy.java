package newstep.progression.leet;

import newstep.progression.leet.MergeTwoSortedLists_21_Easy.ListNode;

public class ReverseLinkedList_206_Easy {

    public ListNode reverseListOwn(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head.next;
        ListNode next = curr == null ? null : curr.next;
        head.next = null;
        ListNode tail = head;

        while (curr != null) {
            curr.next = tail;
            tail = curr;
            curr = next;
            next = curr == null ? null : curr.next;
        }

        return tail;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
