import java.io.*;
import java.util.Arrays;

class Solution2
{
    int dp[][];
    Solution2()
    {
        dp = new int[1002][1002];
        for(int[] ar : dp)
            Arrays.fill(ar,-1);
    }
    public int knapSack(int[] wt,int[] val,int n,int w)
    {
        if(n == 0 || w == 0)
            return 0;
        
        if(dp[n][w] != -1)
            return dp[n][w];
        
        if(wt[n - 1] <= w)
            dp[n][w] = Math.max(val[n - 1] + knapSack(wt, val, n - 1,w - wt[n - 1]),knapSack(wt, val, n - 1,w));
        else
            dp[n][w] = knapSack(wt, val, n - 1,w);
        
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
        
        Solution2 obj = new Solution2();
        System.out.println(obj.knapSack(wt, val, n,w));
    }
}
