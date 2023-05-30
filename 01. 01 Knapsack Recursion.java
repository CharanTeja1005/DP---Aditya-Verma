import java.io.*;

class Solution1
{
    public int knapSack(int W,int wt[],int val[],int n)
    {
        if(n == 0 || W == 0)
            return 0;
        
        if(wt[n - 1] <= W)
            return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),knapSack(W, wt, val, n - 1));
        
        return knapSack(W, wt, val, n - 1);
    }
}

class Knapsack {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        String s[] = br.readLine().trim().split("\\s+");
        int val[] = new int[n];
        for(int i=0;i<n;i++)
            val[i] = Integer.parseInt(s[i]);
        
        s = br.readLine().trim().split("\\s+");
        int wt[] = new int[n];
        for(int i=0;i<n;i++)
            wt[i] = Integer.parseInt(s[i]);
        
        Solution1 obj = new Solution1();
        System.out.println(obj.knapSack(w, wt, val, n));
    }
}
