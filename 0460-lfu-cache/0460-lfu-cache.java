class LFUCache {
    int capacity,minFreq;
    Map<Integer,LFU> keyMap;
    Map<Integer,List<LFU>> freqMap;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=1;
        this.keyMap=new HashMap<>();
        this.freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(keyMap.containsKey(key)){
            update(key,keyMap.get(key).value);
            return keyMap.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyMap.containsKey(key)) update(key,value);
        else if(keyMap.size()<capacity){
            add(key,value);
        }else{
            List<LFU> list=freqMap.get(minFreq);
            LFU temp=list.get(0);
            keyMap.remove(temp.key);
            list.remove(temp);
            add(key,value);
        }
    }
    public void add(int key,int value){
        LFU lfu=new LFU(1,key,value);
        minFreq=1;
        keyMap.put(key,lfu);
        if(freqMap.containsKey(1)){
            freqMap.get(1).add(lfu);
        }else{
            List<LFU> list=new ArrayList<>();
            list.add(lfu);
            freqMap.put(1,list);
        }
    }
    public void update(int key,int value){
        LFU temp=keyMap.get(key);
        freqMap.get(temp.useCnt).remove(temp);
        // keyMap.remove(key);
        if(freqMap.get(temp.useCnt).isEmpty()){
            freqMap.remove(temp.useCnt);
            if(!freqMap.containsKey(minFreq))
             minFreq=temp.useCnt+1;
        }

        if(freqMap.containsKey(temp.useCnt+1)){
            freqMap.get(temp.useCnt+1).add(temp);
        }else{
            List<LFU> list=new ArrayList<>();
            list.add(temp);
            freqMap.put(temp.useCnt+1,list);
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