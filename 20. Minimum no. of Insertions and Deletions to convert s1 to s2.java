import java.io.*;

class Solution20
{
    public int minInsertionsAndDeletions(int n,int m,String s1,String s2)
    {
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

        int lcs = dp[n][m];
        int deletions = n - lcs;
        int insertions = m - lcs;

        return insertions + deletions;
    }
}

class MinimumNoOfInsertionsAndDeletions {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        int n = s1.length();
        int m = s2.length();
        Solution20 ob = new Solution20();
        System.out.println(ob.minInsertionsAndDeletions(n, m, s1, s2));
    }
}
