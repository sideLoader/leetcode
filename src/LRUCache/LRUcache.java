package LRUCache;

import java.util.HashMap;

class Pair<T,K> {
    T key;
    K value;

    public Pair(T key, K value) {
        this.key = key;
        this.value = value;
    }
}

class Node {
    Pair<Integer, Integer> data;
    Node prev, next;

    public Node(int key, int value){
        this.data = new Pair<>(key, value);
        this.prev = this.next = null;
    }
}

public class LRUcache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head, end;

    public LRUcache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = end = null;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            setHead(curr);
            return curr.data.value;
        }

        return -1;
    }

    public void remove(Node n){
        if(n.prev!=null) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next!=null) {
            n.next.prev = n.prev;
        } else {
            end = n.prev;
        }


    }

    public void setHead(Node n){
        n.next = head;
        n.prev = null;

        if(head != null)
            head.prev = n;

        head = n;

        if(end == null)
            end = head;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.data.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if(map.size() >= capacity) {
                map.remove(end.data.key);
                remove(end);
            }
            setHead(created);
            map.put(key, created);
        }
    }


    public static void main(String args[]) {
        LRUcache lruCache = new LRUcache(4);
        lruCache.set(4,5);
        lruCache.set(6,3);
        lruCache.set(7,8);
        lruCache.set(6,3);
        lruCache.set(1,0);

    }
}


