class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map=new HashMap<>();
        int ans=0;
        for(int[] arr:dominoes){
            if(map.containsKey(arr[0]+""+arr[1])){
                ans+=map.get(arr[0]+""+arr[1]);
            }
            if(arr[0]!=arr[1]){
                map.put(arr[0]+""+arr[1],map.getOrDefault(arr[0]+""+arr[1],0)+1);
                map.put(arr[1]+""+arr[0],map.getOrDefault(arr[1]+""+arr[0],0)+1);
            }else{
                map.put(arr[0]+""+arr[1],map.getOrDefault(arr[0]+""+arr[1],0)+1);
            }
        } 
        return ans;
    }
}