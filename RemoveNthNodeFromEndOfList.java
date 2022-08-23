import java.util.*;

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Time Complexity - O(n)
// Space Complexity - O(1)
class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = head;
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }
        
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        return dummy.next;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
class AlternateSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> ptrs = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            ptrs.add(ptr);
            ptr = ptr.next;
        }
        
        if (ptrs.size() == n) {  // Removing the First Element
            head = head.next;
        }
        else { 
            ptrs.get(ptrs.size() - n - 1).next = ptrs.get(ptrs.size() - n).next;
        }
        
        return head;
    }
}