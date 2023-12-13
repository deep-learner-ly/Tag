package algorithm.dfs.backtrack;
//参考力扣200题：岛屿数量


public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean flag=backtrack(board,word,i,j,0);
                if(flag) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word,int i,int j,int k){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(k)){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }

        board[i][j]='0';
        boolean result=backtrack(board,word,i+1,j,k+1)||backtrack(board,word,i-1,j,k+1)||backtrack(board,word,i,j+1,k+1)||backtrack(board,word,i,j-1,k+1);

        board[i][j]=word.charAt(k);
        return result;

    }
}
