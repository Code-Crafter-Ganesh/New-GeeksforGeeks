//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	int TotalWays(int N)
	{
	    // Code here
	      long a = 1,  b=1, c = 1, mod = 1000000007;
      
      for(int i=0;i<N;i++){
          c = (a+b)%mod;
          a = b;
          b = c;
      }
      
      return (int)((c*c)%mod);
        
    
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution ob;
		int ans = ob.TotalWays(N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends