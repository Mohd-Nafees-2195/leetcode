class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set=new HashSet<>();
        int n=nums[0].length();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<n;i++){
            ans.append('0');
        }
        int i=0;
        while(true){
            if(!set.contains(ans.toString())){
                return ans.toString();
            }
            ans.setCharAt(i,'1');
            i++;
        }
    }
}