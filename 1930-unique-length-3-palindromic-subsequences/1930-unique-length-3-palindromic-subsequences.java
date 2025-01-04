class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                ans=Math.max(ans,i-map.get(s.charAt(i))-1);
            }else{
                map.put(s.charAt(i),i);
            }
        }
        return ans;
    }
}