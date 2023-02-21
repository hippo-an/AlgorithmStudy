package newstep.progression.leet;

import java.util.HashMap;
import java.util.Map;
import newstep.progression.leet.MergeTwoSortedLists_21_Easy.ListNode;

public class LinkedListCycle2_142_Medium {

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node = head;
        int idx = 0;
        while(node != null) {
            if(map.containsKey(node)) {
                return node;
            } else {
                map.put(node, idx++);
            }
            node = node.next;
        }
        return null;
    }

    public ListNode detectCycleCv(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;

    }
}
