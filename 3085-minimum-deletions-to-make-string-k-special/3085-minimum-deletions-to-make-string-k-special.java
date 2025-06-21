class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        int n=word.length();
        for(int i=0;i<n;i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }
        for(char ch:map.keySet()){
            set.add(map.get(ch));
        }
        int ans=0;
        while(!set.isEmpty()){
            int max=set.last();
            int min=set.first();
            System.out.println(min+" - "+max);
            if(max-min>k){
                if(min<max-min-k){
                    ans+=min;
                    set.remove(min);
                }else{
                    ans+=(max-min-k);
                    set.remove(max);
                    set.add(min+k);
                }
                
            }else{
                break;
            }
        }
        return ans;
    }
}