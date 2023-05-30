import java.io.*;
import java.util.*;

class Solution7
{
    public int minSubsetSumDifference(int arr[],int n)
    {
        int sum = 0;
        for(int i=0;i<n;i++)
            sum += arr[i];
        
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

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=sum;i++)
        {
            if(dp[n][i])
                list.add(i);
        }

        int res = Integer.MAX_VALUE;
        for(int i=0;i<=list.size()/2;i++)
            res = Math.min(res,Math.abs(sum - 2*list.get(i)));
        
        return res;
    }
}

class MinimumSubsetSumDifference {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(s[i]);

        Solution7 ob = new Solution7();
        System.out.println(ob.minSubsetSumDifference(arr, n));
    }
}
