import java.io.*;
import java.util.Arrays;

class Solution15
{
    int dp[][];

    Solution15()
    {
        dp = new int[1001][1001];
        for(int[] ar : dp)
            Arrays.fill(ar,-1);
    }

    public int LCS(int n,int m,String s1,String s2)
    {
        if(n == 0 || m == 0)
            return 0;
        
        if(dp[n][m] != -1)
            return dp[n][m];
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1))
            dp[n][m] =  1 + LCS(n - 1,m - 1,s1,s2);
        else
            dp[n][m] = Math.max(LCS(n - 1, m, s1, s2),LCS(n, m - 1, s1, s2));
        
        return dp[n][m];
    }
}

class LongestCommonSubsequenceMemoization {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        Solution15 ob = new Solution15();
        System.out.println(ob.LCS(n, m, s1, s2));
    }
}
