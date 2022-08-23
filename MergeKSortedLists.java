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

// Merge Sort Type Implementation
// Time Complexity - O(n * log(k))
// Here, n represents the number of times we perform a Merge Step
// And, k represents the number of Linked Lists we need to Merge
// So, log(k) represents the number of Partitions we can make prior to each Merge Step
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return (ListNode) null;
        }
        
        List<ListNode> listsClone = new ArrayList<>();
        Collections.addAll(listsClone, lists);
        
        while (listsClone.size() > 1) {
            ArrayList<ListNode> merged = new ArrayList<>();
            
            for (int i = 0; i < listsClone.size(); i += 2) {
                ListNode l1 = listsClone.get(i);
                ListNode l2 = (ListNode) null;
                if (i + 1 < listsClone.size()) {
                    l2 = listsClone.get(i + 1);
                }

                merged.add(mergeTwoLists(l1, l2));
            }
            
            listsClone = merged;
        }
        
        return listsClone.get(0);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        }
        else if (l2 != null) {
            tail.next = l2;
        }
        
        return dummy.next;
    }
}

// Time Complexity - O(k * n) 
// k - Number of Sorted Lists, n - Length of Longest Sorted List
class AlternateSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return (ListNode) null;
        }
        if (k == 1) {
            return lists[0];
        }
        
        ListNode res = mergeTwoLists(lists[0], lists[1]);
        if (k == 2) {
            return res;
        }
        
        for (int i = 2; i < k; i++) {
            ListNode temp = lists[i];
            res = mergeTwoLists(res, temp);
        }
        
        return res;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if (l1 != null) {
            tail.next = l1;
        }
        else if (l2 != null) {
            tail.next = l2;
        }
        
        return dummy.next;
    }
}