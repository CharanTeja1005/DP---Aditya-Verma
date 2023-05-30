import java.io.*;

class Solution22
{
    public int minDeletions(int n,String s1)
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

        return n - dp[n][n];
    }
}

class MinimumDeletionsInStringToMakeItPalindrome {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        int n = s1.length();
        Solution22 ob = new Solution22();
        System.out.println(ob.minDeletions(n, s1));
    }
}
