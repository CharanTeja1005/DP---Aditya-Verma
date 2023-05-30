import java.io.*;

class Solution35
{
    public int eggDroppingProblem(int e,int f)
    {
        if(f == 0 || f == 1)
            return f;
        
        if(e == 1)
            return f;
        
        int min = Integer.MAX_VALUE;

        for(int k=1;k<=f;k++)
        {
            int temp = 1 + Math.max(eggDroppingProblem(e - 1, k - 1), eggDroppingProblem(e, f - k));
            min = Math.min(min, temp);
        }

        return min;
    }
}

class EggDroppingProblemRecursion
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_line[] = br.readLine().trim().split("\\s+");
        int e = Integer.parseInt(input_line[0]);
        int f = Integer.parseInt(input_line[1]);
        Solution35 ob = new Solution35();
        System.out.println(ob.eggDroppingProblem(e, f));
    }
}