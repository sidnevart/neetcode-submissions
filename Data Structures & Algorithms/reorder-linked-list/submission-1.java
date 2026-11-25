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
    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;

        while (l2.next != null && l2.next.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l2 = l1.next;
        l1.next = null;
        l1 = head;

        ListNode prev = null;

        while (l2 != null){
            ListNode next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }

        l2 = prev;
        ListNode tail = new ListNode(); 
        while (l2 != null){
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l2.next = next1;

            l1 = next1;
            l2 = next2;
        }

    }
}
