class Solution {
    final int MOD=1000000007;
    Map<Integer,Integer> dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp=new HashMap<>();
        dp.put(0,1);
        int ans=0;
        for(int i=1;i<=high;i++){
            dp.put(i,(dp.getOrDefault(i-one,0)+dp.getOrDefault(i-zero,0))%MOD);
        }
        for(int i=low;i<=high;i++){
            ans=(ans+dp.get(i))%MOD;
        }
        return ans;
    }
}