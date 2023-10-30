//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
      {
       //code here
       int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int row = 0, col = i; row < n - i; row++, col++) {
                boolean isPalindrome = true;
                int ti = row, tj = col;

                while (ti <= tj) {
                    if (str.charAt(ti) != str.charAt(tj)) {
                        isPalindrome = false;
                        break;
                    }
                    ti++;
                    tj--;
                }

                if (isPalindrome) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        dp[row][col] = Math.min(dp[row][k] + dp[k + 1][col] + 1, dp[row][col]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}