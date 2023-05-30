import java.io.*;

class Solution3
{
    public int knapSack(int wt[],int val[],int n,int w)
    {
        int dp[][] = new int[n + 1][w + 1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=w;j++)
            {
                if(wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][w];
    }
}

class Knapsack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        String s[] = br.readLine().trim().split("\\s+");
        int val[] = new int[n];
        for(int i=0;i<n;i++)
            val[i] = Integer.parseInt(s[i]);
        
        s = br.readLine().trim().split("\\s+");
        int wt[] = new int[n];
        for(int i=0;i<n;i++)
            wt[i] = Integer.parseInt(s[i]);
        
        Solution3 obj = new Solution3();
        System.out.println(obj.knapSack(wt, val, n,w));
    }
}
