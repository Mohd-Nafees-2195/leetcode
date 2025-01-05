class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] sweep=new int[n];
        Map<Integer,Character> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,s.charAt(i));
        }
        for(int[] arr:shifts){
           if(arr[2]==0){
             sweep[arr[0]]--;
             if(arr[1]<n-1)
              sweep[arr[1]+1]++;
           }else{
            sweep[arr[0]]++;
            if(arr[1]<n-1)
             sweep[arr[1]+1]--;
           }
        }
        //System.out.println(sweep[0]+" ");
        for(int i=1;i<n;i++){
            sweep[i]=sweep[i]+sweep[i-1];
            //System.out.println(sweep[i]+" ");
        }
        //System.out.println((int)'z'+" "+(int)'a');
        for(int i=0;i<n;i++){
            int ch=map.get(i)+sweep[i];
            if(ch<'a'||ch>'z'){
                if(sweep[i]<0){
                  ch=map.get(i)+sweep[i]+26;
                }else if(sweep[i]>0){
                  ch=map.get(i)+sweep[i]-26;
                }
            }
            map.replace(i,(char)ch);
        }
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<n;i++){
            str.append(map.get(i));
        }
        return str.toString();
    }
}