//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
           int[] freq = new int[3];
        int i=0,n=S.length(),count=0,ans=n+1;
        
        for(int j=0;j<n;j++)
        {
            char ch1 = S.charAt(j);
            freq[ch1-'0']++;
            
            if(freq[ch1-'0']==1)
            {
                count++;
            }
            
            while(i<j && count==3)
            {
                ans = Math.min(j-i+1,ans);
                char ch2 = S.charAt(i++);
                freq[ch2-'0']--;
            
                if(freq[ch2-'0']==0)
                {
                    count--;
                }
            }
        }
        
        return ans==n+1?-1:ans;
    }
};
