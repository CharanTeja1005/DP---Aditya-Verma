import java.io.*;

class Solution5
{
    boolean equalPartition(int arr[],int n)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        if(sum%2 != 0)
            return false;
        
        sum /= 2;
        
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

class EqualSumPartition {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);
        
        Solution5 ob = new Solution5();
        System.out.println(ob.equalPartition(arr, n));
    }
}
