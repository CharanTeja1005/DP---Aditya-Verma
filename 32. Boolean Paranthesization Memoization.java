import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Solution32
{
    Map<String,Integer> map;

    public int solve(String s,int i,int j,boolean isTrue)
    {
        if(i > j)
            return 0;
        
        if(i == j)
        {
            if(isTrue)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        String temp = i + " " + j + " " + isTrue;
        if(map.containsKey(temp))
            return map.get(temp);

        int ans = 0;

        for(int k=i+1;k<j;k++)
        {
            int lT = solve(s,i,k - 1,true);
            int lF = solve(s,i,k - 1,false);
            int rT = solve(s,k + 1,j,true);
            int rF = solve(s,k + 1,j,false);

            if(s.charAt(k) == '&')
            {
                if(isTrue)
                    ans += (lT * rT);
                else
                    ans += (lF * rF) + (lF * rT) + (lT * rF);
            }
            else if(s.charAt(k) == '|')
            {
                if(isTrue)
                    ans += (lT * rT) + (lF * rT) + (lT * rF);
                else
                    ans += (lF * rF);
            }
            else if(s.charAt(k) == '^')
            {
                if(isTrue)
                    ans += (lT * rF) + (lF * rT);
                else
                    ans += (lT * rT) + (lF * rF);
            }
        }

        map.put(temp,ans);
        return ans;
    }

    public int booleanParanthesization(String s)
    {
        map = new HashMap<>();
        return solve(s,0,s.length() - 1,true);
    }
}

class BooleanParanthesizationMemoization {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution32 ob = new Solution32();
        System.out.println(ob.booleanParanthesization(str));
    }
}
