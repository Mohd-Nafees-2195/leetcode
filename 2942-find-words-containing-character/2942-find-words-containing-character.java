class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list=new ArrayList<>();
        int i=0;
        String s=x+"";
        for(String str:words){
            if(str.contains(s)){
                list.add(i);
            }
            i++;
        }
        return list;
    }
}