class LFUCache {
    int capacity;
    Map<Integer,LFU> map;
    LFU head,tail;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=null;
        this.tail=null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            update(key,map.get(key).value);
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) update(key,value);
        else if(map.size()<capacity){
            add(key,value);
        }else{
            map.remove(head.key);
            head=head.next;
            if(head!=null){
                head.prev=null;
            }else{
                tail=null;
            }
            add(key,value);
        }
    }
    public void add(int key,int value){
        LFU lfu=new LFU(1,key,value);
        if(head==null){
            head=lfu;
            tail=head;
        }else{
            LFU temp=head;
            while(temp!=null&&temp.useCnt==1){
                temp=temp.next;
            }
            if(temp!=null){
                if(temp==head){
                    lfu.next=head;
                    head.prev=lfu;
                    head=lfu;
                }else{
                    LFU p=temp.prev;
                    p.next=lfu;
                    lfu.prev=p;
                    lfu.next=temp;
                    temp.prev=lfu;
                }
            }else{
                tail.next=lfu;
                lfu.prev=tail;
                tail=tail.next;
            }
        }
        map.put(key,lfu);
    }
    public void update(int key,int value){
        LFU temp=map.get(key);
        if(temp!=tail){
            if(temp==head){
                head=head.next;
                head.prev=null;
                temp.next=null;
                tail.next=temp;
                temp.prev=tail;
                tail=temp;
            }else{
                LFU p=temp.prev,n=temp.next;
                if(p!=null) p.next=n;
                if(n!=null) n.prev=p;
                temp.next=null;
                tail.next=temp;
                temp.prev=tail;
                tail=temp;
            }
        }
        temp.value=value;
        temp.useCnt=temp.useCnt+1;
    }
    class LFU{
        int useCnt;
        int key,value;
        LFU prev,next;
        LFU(int useCnt,int key,int value){
            this.useCnt=useCnt;
            this.key=key;
            this.value=value;
            this.prev=this.next=null;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */