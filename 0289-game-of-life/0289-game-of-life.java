class Solution {
    public void gameOfLife(int[][] board) {
        int[][] arr=new int[8][2];
        int n=board.length,m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int count=0;
                updateIndex(arr,i,j);
                for(int k=0;k<8;k++){
                    count+=countOnce(board,arr,k,n,m);
                }
                updateLife(count,i,j,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2)
                 board[i][j]=1;
                if(board[i][j]==-1)
                 board[i][j]=0;
            }
        }
    }
    public void updateLife(int count,int i,int j,int[][] board){
        if(board[i][j]==0){
            if(count==3)
             board[i][j]=2;
        }else if(count<2||count>3){
            board[i][j]=-1;
        }
    }
    public int countOnce(int[][] board,int[][] arr,int i,int n,int m){
        if((arr[i][0]>=0&&arr[i][0]<n)&&(arr[i][1]>=0&&arr[i][1]<m)){
            if(board[arr[i][0]][arr[i][1]]==1||board[arr[i][0]][arr[i][1]]==-1)
              return 1;
        }
        return 0;
    }
    public void updateIndex(int[][] arr,int i,int j){
        arr[0][0]=i-1;arr[0][1]=j-1;
        arr[1][0]=i-1;arr[1][1]=j;
        arr[2][0]=i-1;arr[2][1]=j+1;
        arr[3][0]=i;arr[3][1]=j-1;
        arr[4][0]=i;arr[4][1]=j+1;
        arr[5][0]=i+1;arr[5][1]=j-1;
        arr[6][0]=i+1;arr[6][1]=j;
        arr[7][0]=i+1;arr[7][1]=j+1;
    }
}