class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        boolean[] arr=new boolean[n];
        int i=1,count=0;
        while(i<n-1){
            int pre=i-1;
            int next=i+1;
            if(!arr[i]){
                while(pre>=0){
                    if(!arr[pre]&&s.charAt(pre)==s.charAt(i)){
                        arr[pre]=true;
                        count++;
                        break;
                    }
                    pre--;
                }
                while(pre>=0&&next<n){
                    if(!arr[next]&&s.charAt(next)==s.charAt(i)){
                        arr[next]=true;
                        count++;
                        break;
                    }
                    next++;
                }
                if(next==n){
                    arr[pre]=false;
                    count--;
                }
            }
            i++;
        }
        return n-count;
    }
}