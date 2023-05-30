import java.io.*;

class Solution14
{
    public int LCS(int n,int m,String s1,String s2)
    {
        if(n == 0 || m == 0)
            return 0;
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1))
            return 1 + LCS(n - 1,m - 1,s1,s2);
        
        return Math.max(LCS(n - 1, m, s1, s2),LCS(n, m - 1, s1, s2));
    }
}

class LongestCommonSubsequenceRecursion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        Solution14 ob = new Solution14();
        System.out.println(ob.LCS(n, m, s1, s2));
    }
}
