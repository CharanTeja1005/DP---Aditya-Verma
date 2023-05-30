import java.io.*;

class Solution21
{
    public int LPS(int n,String s1)
    {
        StringBuilder rev = new StringBuilder(s1);
        String s2 = rev.reverse().toString();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }

    public int anotherWayLPS(int n,String s1)
    {
        int dp[][] = new int[n + 1][n + 1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i - 1) == s1.charAt(n - j))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}

class LongestPalindromicSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        int n = s1.length();
        Solution21 ob = new Solution21();
        System.out.println(ob.LPS(n, s1));
        System.out.println(ob.anotherWayLPS(n, s1));
    }
}
