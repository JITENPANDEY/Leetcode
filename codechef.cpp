// Author : Jiten Pandey
// Submitted on : codechef

#include<bits/stdc++.h>
using namespace std;
#define ll long long int
#define mod 1000000007
#define pb push_back
#define ld long double
#define f(i,a,b) for(ll i=a;i<b;i++)
#define fr(i,a,b) for(ll i=b-1;i>=a;i--)
#define in(a) cin>>a
#define out(b) cout<<b
#define v(type) vector<type>v
#define m(type1,type2) map<type1,type2>m
string solve(string s,ll n){
	string ans="";
	string str = "abcdefghijklmnop";
	
	ll low =0;
	ll high = str.length()-1;
	ll mid;
	for(ll i=0;i<n;i++)
	{
		
		mid = (low + high)/2;
		cout<<mid<<endl;
		if(s[i]=='0')
		high = mid;
		else if(s[i]=='1')
		low = mid + 1;
		
		cout<<low<<" "<<high<<endl;
		
		if(low==high)
		{
			cout<<"equal"<<endl;
		ans+=str[low];
		low =0;
		high = str.length()-1;
		}
		
	}
	return ans;
}
int main()
{
	int t;
	cin>>t;
	while(t--){
		ll n;
		string s;
		cin>>n;
		cin>>s;
		
		cout<<solve(s,n)<<endl;
	}
	return 0;
}

