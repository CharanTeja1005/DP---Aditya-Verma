import java.io.*;
import java.util.Arrays;

class Solution36
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
            int temp = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));
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

class EggDroppingProblemMemoization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_line[] = br.readLine().trim().split("\\s+");
        int e = Integer.parseInt(input_line[0]);
        int f = Integer.parseInt(input_line[1]);
        Solution36 ob = new Solution36();
        System.out.println(ob.eggDroppingProblem(e, f));
    }
}
