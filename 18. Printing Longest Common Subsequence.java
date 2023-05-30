import java.io.*;

class Solution18
{
    public String printLCS(int n,int m,String s1,String s2)
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

        int i = n;
        int j = m;
        String res = "";

        while(i > 0 && j > 0)
        {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                res = s1.charAt(i - 1) + res;
                i--;
                j--;
            }
            else
            {
                if(dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        }

        return res;
    }

    public String anotherWayToPrintLCS(int n,int m,String s1,String s2)
    {
        String dp[][] = new String[n + 1][m + 1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = "";
                else if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                else
                    dp[i][j] = (dp[i - 1][j].length() > dp[i][j - 1].length()) ? dp[i - 1][j] : dp[i][j - 1];
            }
        }

        return dp[n][m];
    }
}

class PrintingLongestCommonSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        Solution18 ob = new Solution18();
        System.out.println(ob.printLCS(n, m, s1, s2));
        System.out.println(ob.anotherWayToPrintLCS(n, m, s1, s2));
    }
}
