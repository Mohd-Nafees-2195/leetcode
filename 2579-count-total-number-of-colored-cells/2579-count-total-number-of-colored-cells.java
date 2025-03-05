class Solution {
    public long coloredCells(int n) {
        return getColoredCell(n);
    }
    public long getColoredCell(int n){
        if(n==1)
         return 1;
        return 4*(n-1)+getColoredCell(n-1);
    }
}