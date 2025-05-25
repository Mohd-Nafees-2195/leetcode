class Solution {
    public int longestPalindrome(String[] words) {
        int ans=0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            StringBuilder str=new StringBuilder(words[i]);
            if(map.containsKey(str.reverse().toString())){
                ans+=4;
                map.remove(str.reverse().toString());
            }else{
                map.put(words[i],map.getOrDefault(words[i],0)+1);
            }
        }
        for(String str:map.keySet()){
            if(map.get(str)==1){
                StringBuilder str1=new StringBuilder(str);
                if(str.equals(str1.reverse().toString())){
                    ans+=2;
                    break;
                }
            }
        }
        return ans;
    }
}