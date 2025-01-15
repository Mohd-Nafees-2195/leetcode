class Solution {
    public int minimizeXor(int num1, int num2) {
        int countOnce=Integer.bitCount(num2);
        int bit=31;
        int ans=0;
        while(countOnce>0&&bit>0){
            if((num1&(1<<bit))!=0){
                ans=ans|(1<<bit);
                countOnce--;
            }
            bit--;
        }
        bit=0;
        while(countOnce>0){
            if((ans&(1<<bit))==0){
                ans=ans|(1<<bit);
            }
            bit++;
            countOnce--;
        }
        return ans;
    }
}