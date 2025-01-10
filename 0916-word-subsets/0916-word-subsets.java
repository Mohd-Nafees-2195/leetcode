class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans=new ArrayList<>();
        List<Map<Character,Integer>> list=new ArrayList<>();
        int n1=words1.length;
        int n2=words2.length;
        for(int i=0;i<n2;i++){
            Map<Character,Integer> map=new HashMap<>();
            int j=words2[i].length()-1;
            while(j>=0){
                map.put(words2[i].charAt(j),map.getOrDefault(words2[i].charAt(j),0)+1);
                j--;
            }
            list.add(map);
        }
        for(int i=0;i<n1;i++){
            int n=words1[i].length();
            int k=0,j=0;
            boolean check=false;
            Map<Character,Integer> m=new HashMap<>();
            while(j<n){
                m.put(words1[i].charAt(j),m.getOrDefault(words1[i].charAt(j),0)+1);
                j++;
            }
            while(k<n2){
                for(char ch:list.get(k).keySet()){
                    if(m.containsKey(ch)){
                        if(list.get(k).get(ch)>m.get(ch)){
                            check=true;
                            break;
                        }
                    }else{
                        check=true;
                        break;
                    }
                }
                if(check){
                    break;
                }
                k++;
            }
            if(n2==k)
             ans.add(words1[i]);
        }
        return ans;
    }
}