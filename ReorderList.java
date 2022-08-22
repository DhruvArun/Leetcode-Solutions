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
// Space Complexity - O(1), Since we DON'T use an extra ArrayList
class ReorderList {
    public void reorderList(ListNode head) {
        // Find Middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse Second Portion of Linked List
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        
        // Merge Two Halves
        ListNode first = head;
        second = prev;
        
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
class AlternateSolution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> lst = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            lst.add(temp);
            temp = temp.next;
        }
        ArrayList<ListNode> lstRev = (ArrayList<ListNode>) lst.clone();
        Collections.reverse(lstRev);
        
        int limit;
        if(lst.size() % 2 != 0) {
            limit = (lst.size() / 2) + 1;
        }
        else {
            limit = lst.size() / 2;
        }
        
        temp = new ListNode();
        int i = 0;
        while (i < limit) {
            ListNode n1 = lst.get(i);
            temp.next = n1;
            
            ListNode n2 = lstRev.get(i);
            n1.next = n2;
            
            temp = n2;
            temp.next = null;
            
            i++;
        }
    }
}