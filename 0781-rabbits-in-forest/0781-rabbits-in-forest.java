class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0,once=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==0){
                ans++;
            }else{
                map.put(answers[i],map.getOrDefault(answers[i],0)+1);
                if(map.get(answers[i])>answers[i]+1){
                    ans+=answers[i]+1;
                    map.put(answers[i],1);
                }else{
                    if(map.get(answers[i])==1)
                     ans+=answers[i]+1;
                }
            }
        }
        return ans;
    }
}