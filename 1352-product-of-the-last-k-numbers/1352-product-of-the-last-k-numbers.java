class ProductOfNumbers {
    List<Integer> stream;
    public ProductOfNumbers() {
        stream=new ArrayList<>();
    }
    
    public void add(int num) {
        stream.add(num);
    }
    
    public int getProduct(int k) {
        int it=0,n=stream.size();
        int ans=1;
        while(it<k){
            ans*=stream.get(n-1-it);
            it++;
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */