import java.io.*;

class Solution9
{
    public int targetSum(int arr[],int n,int target)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        
        if(Math.abs(target) > sum || (sum + target)%2 != 0)
            return 0;
        
        sum = (sum + target)/2;

        int dp[][] = new int[n + 1][sum + 1];
        
        dp[0][0] = 1;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
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

class TargetSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        
        int sum = Integer.parseInt(br.readLine());

        Solution9 ob = new Solution9();
        System.out.println(ob.targetSum(arr, n, sum));
    }
}
