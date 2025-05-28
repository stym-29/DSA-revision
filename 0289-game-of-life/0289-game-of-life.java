class Solution {
    public void gameOfLife(int[][] board) {
      int n=board.length;
      int m=board[0].length;
      int arr[][]=new int[n][m];  
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
        {
            int a=board[i][j];
            int count=0;
           if(i>0)
           {
             if(board[i-1][j]==1)
             {
                count++;
             }
           }
           if(i<n-1)
           {
            if(board[i+1][j]==1)
            {
                count++;
            }
           }
           if(j>0)
           {
            if(board[i][j-1]==1)
            {
                count++;
            }
           } 
           if(j<m-1)
           {
            if(board[i][j+1]==1)
            {
                count++;
            }
           }
           if(i>0 && j>0)
           {
            if(board[i-1][j-1]==1)
            {
                count++;
            }
           }
           if(i<n-1 && j<m-1)
           {
             if(board[i+1][j+1]==1)
             {
                count++;
             }
           }
           if(i>0 && j<m-1)
           {
            if(board[i-1][j+1]==1)
            {
                count++;
            }
           }
           if(i<n-1 && j>0)
           {
            if(board[i+1][j-1]==1)
            {
                count++;
            }
           }
           if(a==1 && count<2)
           {
              arr[i][j]=0;
           }
           else if(a==1 && (count==2 || count==3))
           {
            arr[i][j]=1;
           }
           else if(a==1 && count>3)
           {
             arr[i][j]=0;
           }
           else if(a==0 && count==3)
           {
            arr[i][j]=1;
           }
           else{
            arr[i][j]=0;
           }
        }
      }
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<m;j++)
        {
            board[i][j]=arr[i][j];
        }
      }
    }
}