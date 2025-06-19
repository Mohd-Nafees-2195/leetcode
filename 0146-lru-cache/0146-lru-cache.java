class LRUCache {
    int capacity;
    Map<Integer,Node> map;
    LinkedHashSet<Node> set;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.set=new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            set.remove(temp);
            set.add(temp);
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(map.containsKey(key)){
            Node temp=map.get(key);
            set.remove(temp);
            temp.value=value;
            set.add(temp);
        }else if(map.size()<capacity){
            Node temp=new Node(key,value);
            map.put(key,temp);
            set.add(temp);
        }else{
            Node temp=set.iterator().next();
            map.remove(temp.key);
            set.remove(temp);
            temp.key=key;temp.value=value;
            map.put(key,temp);
            set.add(temp);
        }
    }
    class Node{
        int key,value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */