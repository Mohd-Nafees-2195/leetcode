class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int[] temp=Arrays.copyOf(nums,n);
        Map<Integer,Deque<Integer>> group=new HashMap<>();
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(temp);
        for(int i=0;i<n;i++){
            if(i==0){
                Deque<Integer> dq=new LinkedList<>();
                dq.addFirst(temp[i]);
                group.put(0,dq);
                map.put(temp[i],0);
            }else{
                Deque<Integer> dq=group.get(group.size()-1);
                if(Math.abs(dq.peekLast()-temp[i])<=limit){
                    dq.addLast(temp[i]);
                }else{
                    Deque<Integer> dq1=new LinkedList<>();
                    dq1.addFirst(temp[i]);
                    group.put(group.size(),dq1);
                }
                map.put(temp[i],group.size()-1);
            }
        }
        for(int i=0;i<n;i++){
            int g=map.get(nums[i]);
            Deque<Integer> dq=group.get(g);
            if(!dq.isEmpty())
             nums[i]=dq.pollFirst();
        }
        return nums;
    }
}