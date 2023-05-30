import java.io.*;
import java.util.Arrays;

class Solution37
{
    int dp[][];
    
    public int solve(int e,int f)
    {
        if(f == 0 || f == 1)
            return f;
        
        if(e == 1)
            return f;
        
        if(dp[e][f] != -1)
            return dp[e][f];
        
        int min = Integer.MAX_VALUE;

        for(int k=1;k<=f;k++)
        {
            int left = 0;
            if(dp[e - 1][k - 1] != -1)
                left = dp[e - 1][k - 1];
            else
            {
                left = solve(e - 1, k - 1);
                dp[e - 1][k - 1] = left;
            }

            int right = 0;
            if(dp[e][f - k] != -1)
                right = dp[e][f - k];
            else
            {
                right = solve(e, f - k);
                dp[e][f - k] = right;
            }

            int temp = 1 + Math.max(left,right);
            min = Math.min(min, temp);
        }

        dp[e][f] = min;
        return min;
    }

    public int eggDroppingProblem(int e,int f)
    {
        dp = new int[e + 1][f + 1];
        for(int[] ar : dp)
            Arrays.fill(ar,-1);
        return solve(e, f);
    }
}

class EggDroppingProblemMemoizationOptimization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_line[] = br.readLine().trim().split("\\s+");
        int e = Integer.parseInt(input_line[0]);
        int f = Integer.parseInt(input_line[1]);
        Solution37 ob = new Solution37();
        System.out.println(ob.eggDroppingProblem(e, f));
    }
}
