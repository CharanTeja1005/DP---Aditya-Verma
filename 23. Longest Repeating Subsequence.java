import java.io.*;

class Solution23
{
    public int LRS(int n,String s1)
    {
        int dp[][] = new int[n + 1][n + 1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i - 1) == s1.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }

        return dp[n][n];
    }
}

class LongestRepeatingSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        int n = s1.length();
        Solution23 ob = new Solution23();
        System.out.println(ob.LRS(n, s1));
    }
}
