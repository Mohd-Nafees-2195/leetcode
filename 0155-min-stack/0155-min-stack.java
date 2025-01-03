class MinStack {
    Node head,tail;
    public MinStack() {
        head=null;tail=null;
    }
    
    public void push(int val) {
        if(tail==null){
            head=new Node(val,val);
            tail=head;
        }else{
            if(tail.minVal>val)
             tail.next=new Node(val,val);
            else
             tail.next=new Node(val,tail.minVal);
            tail.next.prev=tail;
            tail=tail.next;
        }
    }
    
    public void pop() {
        if(head==tail){
            head=null;
            tail=null;
        }else{
            tail=tail.prev;
            tail.next=null;
        }
    }
    
    public int top() {
        if(tail!=null)
         return tail.val;
        return -1;
    }
    
    public int getMin() {
        if(tail!=null)
         return tail.minVal;
        return -1;
    }

    public class Node{
        int val,minVal;
        Node prev,next;
        public Node(int val,int minVal){
            this.val=val;
            this.minVal=minVal;
            this.prev=null;
            this.next=null;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */