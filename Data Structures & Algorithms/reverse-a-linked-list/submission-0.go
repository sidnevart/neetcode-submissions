/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head // 0
	
	for curr != nil {
		next := curr.Next  // 1
		curr.Next = prev // {}
		prev = curr // 0
		curr = next // 1
	}

	return prev
}

