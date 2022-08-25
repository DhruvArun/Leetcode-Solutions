import java.util.*;

class LRUCache {
    public Map<Integer, Node> cache = new HashMap<>();
    public int capacity;

    public Node left;
    public Node right;
    
    class Node {
        public int key;
        public int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        // Left = LRU , Right = MRU
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        else {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key,value));
        insert(cache.get(key));
        
        if (cache.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
    
    // Remove from List
    public void remove (Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    // Insert at Right 
    public void insert (Node node) {
        Node prev = right.prev;
        Node next = right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */