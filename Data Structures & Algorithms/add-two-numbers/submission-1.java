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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = new ListNode();
        dummy.next = res;
        int carry = 0;
        while (l1 != null || l2 != null){
            int digit_l1 = (l1 == null) ? 0 : l1.val;
            int digit_l2 = (l2 == null) ? 0 : l2.val;
            int sum = digit_l1 + digit_l2 + carry;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            // handle last digit(-s)
            if (l1 == null && l2 == null) {
                do {
                    int digit = sum % 10;
                    res.next = new ListNode(digit);
                    res = res.next;
                    sum /= 10;
                } while (sum != 0);

                break;
            }

            res.next = new ListNode(sum % 10);
            res = res.next;

            if (sum >= 10){
                carry = 1;
            } else {
                carry = 0;
            }

        }

        return dummy.next.next;
    }
}
