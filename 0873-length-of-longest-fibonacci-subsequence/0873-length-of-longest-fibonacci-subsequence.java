class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        for(int i=0;i<n-2;i++){
            int max=0;
            int j=i+1;
            int a=arr[i];
            int b=arr[j];
            while(map.containsKey(a+b)){
                int c=a+b;
                a=b;
                b=c;
                max=(max==0)?3:max+1;
            }
            ans=Math.max(ans,max);
        }
        return ans;
    }
}