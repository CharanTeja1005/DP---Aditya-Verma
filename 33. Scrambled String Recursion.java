import java.io.*;

class Solution33
{
    public boolean scrambledString(String a,String b)
    {
        if(a.equals(b))
            return true;
        
        if(a.length() <= 1)
            return false;
        
        boolean flag = false;
        int n = a.length();

        for(int i=1;i<n;i++)
        {
            boolean swap = scrambledString(a.substring(0, i), b.substring(n - i)) && scrambledString(a.substring(i), b.substring(0, n - i));
            boolean noSwap = scrambledString(a.substring(0, i), b.substring(0, i)) && scrambledString(a.substring(i), b.substring(i));
            if(swap || noSwap)
                flag = true;
        }

        return flag;
    }
}

class ScrambledStringRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        Solution33 ob = new Solution33();
        System.out.println(ob.scrambledString(a, b));
    }
}
