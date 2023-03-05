package newstep.progression.leet;

import newstep.progression.leet.MergeTwoSortedLists_21_Easy.ListNode;


public class AddTwoNumbers_2_Medium {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode root = new ListNode();
        ListNode next = root;

        int sum = 0;
        while (first != null || second != null) {
            sum /= 10;

            if (first != null) {
                sum += first.val;
                first = first.next;
            }

            if (second != null) {
                sum += second.val;
                second = second.next;
            }

            next.next = new ListNode(sum % 10);
            next = next.next;
        }

        if (sum > 9) {
            next.next = new ListNode(sum / 10);
        }

        return root.next;
    }
}
