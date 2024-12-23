class LRUCache {
    int capacity;
    Node head, tail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {

            Node temp = cache.get(key);
            int value=temp.value;
            delete(temp);
            add(key,value);
            return value;
        } else
            return -1;

    }

    public void put(int key, int value) {
         if (cache.containsKey(key)) {
            delete(cache.get(key));
            add(key,value);
        } else if (cache.size() == capacity) {
            delete(head);
            add(key, value);
        } else {
             add(key, value);
        }
    }

    public void delete(Node temp) {
        cache.remove(temp.key);
        if (head == tail) {
            head = null;
            tail = null;
        } else if (temp == tail) {
          tail=temp.prev;
          temp.prev=null;
          tail.next=null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
            temp.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.next = null;
            temp.prev = null;
        }
    }

    public void add(int key,int value) {
        Node temp=new Node(key,value);
        if(head==null){
            head=temp;
            tail=temp;
        }else{
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
        }
       cache.put(key,temp);
    }
}

class Node {
    int value;
    int key;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.value = value;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */