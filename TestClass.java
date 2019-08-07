import java.io.*;
import java.util.*;
 
 
public class TestClass {
    static final int MAX = 26;
    public static boolean[] vis = new boolean[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();
 
        int out_ = SmallestSubString(S);
        wr.println(out_);
 
        wr.close();
        br.close();
    }
 
    static int SmallestSubString(String str) {
        int n = str.length();
        int dcnt = 0;
        for(int i=0; i<n; ++i)
        {
            if(vis[str.charAt(i)-97] == false)
            {
                vis[str.charAt(i)-97] = true;
                ++dcnt;
            }
        }
        
        int st = 0, ind = -1, mn=Integer.MAX_VALUE, cnt = 0;
        int[] curr = new int[MAX];
        
        for(int i=0; i<n;++i)
        {
            curr[str.charAt(i)-97]++;
            
            if(curr[str.charAt(i)-97] == 1)
                cnt++;
            
            if(cnt == dcnt)
            {
                while(curr[str.charAt(st)-97] > 1)
                {
                    --curr[str.charAt(st)-97];
                    st++;
                }
                
                int  window = i - st + 1;
                if(window < mn)
                    mn = window;
            }
        }
        
        return mn;
 
    }
} 