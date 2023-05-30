import java.io.*;

class Solution17
{
    public int LCS(int n,int m,String s1,String s2)
    {
        int dp[][] = new int[n + 1][m + 1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0;
            }
        }
        
        int res = Integer.MIN_VALUE;
    
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                res = Math.max(res,dp[i][j]);
            }
        }
    
        return res;
    }

}

class LongestCommonSubstring {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        Solution17 ob = new Solution17();
        System.out.println(ob.LCS(n, m, s1, s2));
    }
}
