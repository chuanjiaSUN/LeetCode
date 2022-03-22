package Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-22 0:28
 */
public class LRUCache {

    int size;
    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(){}

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }



    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            Node res = new Node(key, value);
            cache.put(key, res);
            size++;
            addToHead(res);

            if(size > capacity){
                Node ta = removeTail();
                cache.remove(ta.key);
                size--;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(Node node){
        Node pre = node.prev;
        Node nex = node.next;
        pre.next = nex;
        nex.prev = pre;
    }

    public void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public Node removeTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
