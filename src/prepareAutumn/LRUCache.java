package prepareAutumn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-26 23:04
 */
public class LRUCache {
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(){}
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, Node> cache = new HashMap<>();
    int size;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity){
                Node tail;
                tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    private void removeNode(Node node) {
        Node prev = node.pre;
        node.pre.next = node.next;
        node.next.pre = prev;
    }


    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}
