class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans=new ArrayList<>();
        int n=words.length;
        boolean flag=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int n1=words[i].length();
                    int n2=words[j].length();
                    if(n1<=n2){
                        int k=0;
                        while(k<=n2-n1){
                            if(words[i].charAt(0)==words[j].charAt(k)){
                                if(words[j].substring(k,k+n1).equals(words[i])){
                                    ans.add(words[i]);
                                    flag=true;
                                    break;
                                }
                            }
                            k++;
                        }
                    }
                }
                if(flag){
                    flag=false;
                    break;
                }
            }
        }
        return ans;
    }
}