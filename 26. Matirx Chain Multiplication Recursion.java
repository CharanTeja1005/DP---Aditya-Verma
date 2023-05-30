import java.io.*;

class Solution26
{
    public int solve(int arr[],int i,int j)
    {
        if(i >= j)
            return 0;
        
        int min = Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++)
        {
            int temp = solve(arr,i,k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);

            if(temp < min)
                min = temp;
        }

        return min;
    }

    public int matirxChainMultiplication(int n,int arr[])
    {
        return solve(arr,1,n - 1);
    }
}

class MatirxChainMultiplicationRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input_line[] = br.readLine().trim().split("\\s+");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(input_line[i]);
        
        Solution26 ob = new Solution26();
        System.out.println(ob.matirxChainMultiplication(n, arr));
    }
}
