class Solution {
    int n;
    public int numTilePossibilities(String tiles) {
        n=tiles.length();
        boolean[] used=new boolean[n];
        Set<String> set=new HashSet<>();
        backtrack(tiles,used,set,"");
        return set.size()-1;
    }
    public void backtrack(String tiles,boolean[] used,Set<String> set,String curr){
        if(set.contains(curr)) return;
        set.add(curr);
        for(int i=0;i<n;i++){
            if(used[i]) continue;
            used[i]=true;
            backtrack(tiles,used,set,curr+tiles.charAt(i));
            used[i]=false;
        }
    }
}