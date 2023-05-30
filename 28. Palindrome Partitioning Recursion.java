import java.io.*;

class Solution28
{
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
        
        if(isPalindrome(s,i,j))
            return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++)
        {
            int temp = solve(s,i,k) + solve(s,k + 1,j) + 1;

            if(temp < min)
                min = temp;
        }

        return min;
    }

    public int palindromePartitioning(String s)
    {
        return solve(s,0,s.length() - 1);
    }
}

class PalindromePartitioningRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Solution28 ob = new Solution28();
        System.out.println(ob.palindromePartitioning(s));
    }
}
