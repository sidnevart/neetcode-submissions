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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        head = dummy.next;
        int idx = 1;
        ListNode prev = new ListNode();
        prev.next = head;
        dummy.next = prev;
        while (head != null){
            if (idx == size - n + 1){
                prev.next = head.next;
                head = null;
                break;
            }
            idx++;
            prev = head;
            head = head.next;
        }

        return dummy.next.next;

    }
}
