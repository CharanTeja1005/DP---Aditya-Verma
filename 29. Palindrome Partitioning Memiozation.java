import java.io.*;
import java.util.Arrays;

class Solution29
{
    int dp[][];

    public boolean isPalindrome(String s,int i,int j)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int solve(String s,int i,int j)
    {
        if(i >= j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(isPalindrome(s,i,j))
            return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++)
        {
            int temp = solve(s,i,k) + solve(s,k + 1,j) + 1;

            if(temp < min)
                min = temp;
        }

        dp[i][j] = min;
        return min;
    }

    public int palindromePartitioning(String s)
    {
        dp = new int[s.length() + 1][s.length() + 1];
        for(int ar[] : dp)
            Arrays.fill(ar,-1);
        return solve(s,0,s.length() - 1);
    }
}

class PalindromePartitioningMemoization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Solution29 ob = new Solution29();
        System.out.println(ob.palindromePartitioning(s));
    }
}
