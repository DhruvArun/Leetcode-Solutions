import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}

// Floyd's Tortoise and Hare Algorithm to Find a Cycle in a Linked List
// Time Complexity - O(n)
// It takes (n - 1) iterations before Slow & Fast pointer meet (If there is a Cycle in the Linked List)
// Space Complexity - O(1), Since we DON'T use a HashSet
class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow.equals(fast)) {
                return true;
            }
        }
        
        return false;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
class AlternateSolution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        
        return false;
    }
}