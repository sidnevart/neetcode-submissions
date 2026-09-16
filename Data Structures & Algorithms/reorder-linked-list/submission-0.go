/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reorderList(head *ListNode) {
	cur := head
	arr := []*ListNode{}
	for cur != nil {
		arr = append(arr, cur)
		cur = cur.Next
	}

	n := len(arr)
	left := 0
	right := n - 1
	for left < right {
		arr[left].Next = arr[right]   
		left++
		if left == right {
			break
		}
		arr[right].Next = arr[left]  
		right--
	}

	arr[left].Next = nil
}
