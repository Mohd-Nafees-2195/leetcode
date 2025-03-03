class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Stack<Integer> minStack=new Stack<>();
        Stack<Integer> maxStack=new Stack<>();
        int n=nums.length,cnt=0;
        for(int i=n-1;i>=0;i--){
            if(nums[i]>pivot)
             maxStack.push(nums[i]);
            else if(nums[i]<pivot)
             minStack.push(nums[i]);
            else
             cnt++;
        }
        int i=0;
        while(!minStack.isEmpty()){
            nums[i++]=minStack.pop();
        }
        while(cnt>0){
            nums[i++]=pivot;
            cnt--;
        }
        while(!maxStack.isEmpty()){
            nums[i++]=maxStack.pop();
        }
        return nums;
    }
}