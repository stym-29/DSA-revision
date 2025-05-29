/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode current = head;
        int position = 1;

        if (left == 1 && right == 1) return head;

        while (position < left) {
            prev = current;
            current = current.next;
            position++;
        }

        ListNode nodeBeforeSublist = prev;
        ListNode tailOfSublist = current;

        int count = right - left + 1;
        prev = null;

        while (count > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }

        if (nodeBeforeSublist != null) {
            nodeBeforeSublist.next = prev;
        } else {
            head = prev;
        }

        tailOfSublist.next = current;

        return head;
    }
}
