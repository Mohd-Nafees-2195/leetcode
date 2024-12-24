class Solution {
    static List<List<Integer> > wlist=new ArrayList<>();
    void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    List<List<Integer>> permute(int n,int i,int nums[])
    {
        if(i==n)
        {
            
            List<Integer> list=new ArrayList<Integer>();
            for(int k=0;k<n;k++)
                list.add(nums[k]);
            wlist.add(list);
            return wlist;
        }
        for(int j=i;j<n;j++)
        {
            swap(nums,i,j);
            permute(n,i+1,nums);
            swap(nums,i,j);
        }
        return wlist;
        
    }
    public List<List<Integer>> permute(int[] nums) {
        wlist.clear();
        return permute(nums.length,0,nums);
    }
}