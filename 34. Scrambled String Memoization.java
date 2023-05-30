import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Solution34
{
    Map<String,Boolean> map = new HashMap<>();;

    public boolean scrambledString(String a,String b)
    {
        if(a.equals(b))
            return true;
        
        if(a.length() <= 1)
            return false;

        String key = a + " " + b;
        if(map.containsKey(key))
            return map.get(key);
        
        boolean flag = false;
        int n = a.length();

        for(int i=1;i<n;i++)
        {
            boolean swap = scrambledString(a.substring(0, i), b.substring(n - i)) && scrambledString(a.substring(i), b.substring(0, n - i));
            boolean noSwap = scrambledString(a.substring(0, i), b.substring(0, i)) && scrambledString(a.substring(i), b.substring(i));
            if(swap || noSwap)
                flag = true;
        }

        map.put(key,flag);
        return flag;
    }
}

class ScrambledStringMemoization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        Solution34 ob = new Solution34();
        System.out.println(ob.scrambledString(a, b));
    }
}
