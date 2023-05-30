import java.io.*;

class Solution6
{
    public int countSubsetsSum(int arr[],int n,int sum)
    {
        int dp[][] = new int[n + 1][sum + 1];
        
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}

class CountofSubsetswithgivenSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        
        int sum = Integer.parseInt(br.readLine());

        Solution6 ob = new Solution6();
        System.out.println(ob.countSubsetsSum(arr, n, sum));
    }
}
