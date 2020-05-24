class Solution {
    public int superEggDrop(int K, int N) {
        int [][]dp=new int [K+1][N+1];
        //��������
        //��ʾi,j״̬�µĽ�
        int i,j,k;
        int prevx;//����ͬһ��k�£���ʹdp[k][j-1]ȡ�����ֵ��x        
        for(i=0;i<N+1;i++)
            dp[1][i]=i;
        for(i=0;i<K+1;i++)
            dp[i][1]=1;
        for(i=2;i<K+1;i++)
        {
            prevx=1;
            for(j=2;j<N+1;j++)
            {
                while(Math.max(dp[i-1][prevx-1],dp[i][j-prevx])>
                        Math.max(dp[i-1][prevx],dp[i][j-prevx-1]))
                        prevx++;
                dp[i][j]=1+Math.max(dp[i-1][prevx-1],dp[i][j-prevx]);
            }
        }
        return dp[K][N];
    }
}