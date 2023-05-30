import java.io.*;

class Solution12
{
    public int coinChange(int coins[],int n,int sum)
    {
        int dp[][] = new int[n + 1][sum + 1];
        
        for(int i=1;i<=n;i++)
            dp[i][0] = 1;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(coins[i - 1] <= j)
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}

class CoinChangeProblem1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int coins[] = new int[n];
        for(int i=0;i<n;i++)
            coins[i] = Integer.parseInt(s[i]);
        
        int sum = Integer.parseInt(br.readLine());

        Solution12 ob = new Solution12();
        System.out.println(ob.coinChange(coins, n, sum));
    }
}
