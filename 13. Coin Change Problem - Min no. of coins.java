import java.io.*;

class Solution13
{
    public int coinChange(int coins[],int n,int sum)
    {
        int dp[][] = new int[n + 1][sum + 1];
        
        //  1st Row
        for(int i=1;i<=sum;i++)
            dp[0][i] = Integer.MAX_VALUE - 1;
        
        //  2nd Row
        for(int j=1;j<=sum;j++)
        {
            if(j%coins[0] == 0)
                dp[1][j] = j/coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(coins[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]],dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return (dp[n][sum] > sum) ? -1 : dp[n][sum];
    }
}

class CoinChangeProblem2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int coins[] = new int[n];
        for(int i=0;i<n;i++)
            coins[i] = Integer.parseInt(s[i]);
        
        int sum = Integer.parseInt(br.readLine());

        Solution13 ob = new Solution13();
        System.out.println(ob.coinChange(coins, n, sum));
    }
}
