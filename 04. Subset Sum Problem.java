import java.io.*;

class Solution4
{
    boolean isSubsetSum(int arr[],int n,int sum)
    {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        
        for(int i=0;i<=n;i++)
            dp[i][0] = true;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}

class SubsetSumProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        
        int sum = Integer.parseInt(br.readLine());

        Solution4 ob = new Solution4();
        System.out.println(ob.isSubsetSum(arr, n, sum));
    }
}
