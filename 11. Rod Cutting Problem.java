import java.io.*;

class Solution11
{
    public int rodCuttingProblem(int length[],int price[],int n,int l)
    {
        int dp[][] = new int[n + 1][l + 1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=l;j++)
            {
                if(length[i - 1] <= j)
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]],dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][l];
    }
}

class RodCuttingProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());

        String s[] = br.readLine().trim().split("\\s+");
        int price[] = new int[n];
        for(int i=0;i<n;i++)
            price[i] = Integer.parseInt(s[i]);
        
        s = br.readLine().trim().split("\\s+");
        int length[] = new int[n];
        for(int i=0;i<n;i++)
            length[i] = Integer.parseInt(s[i]);
        
        Solution11 obj = new Solution11();
        System.out.println(obj.rodCuttingProblem(length, price, n,l));
    }
}
