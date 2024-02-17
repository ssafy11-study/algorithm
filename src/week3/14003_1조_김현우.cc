#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void) {
	fastio;
	int N ,tmp;
	vector <int> check , v ,num;
	stack <int> st;
	cin >> N;
	int n = 1;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		v.push_back(tmp);
		if (check.size() == 0 || check.back()< tmp) {
			check.push_back(tmp);
			num.push_back(n);
			n++;
		}
		else if (check.back() >= tmp) {
		    num.push_back(lower_bound(check.begin(), check.end(), tmp)- check.begin()+1);
			check[lower_bound(check.begin(), check.end(), tmp)- check.begin()] = tmp;
		}
	}
	n -=1;
	cout << n <<"\n";
	for(int i = num.size()-1; i>=0; i--){
	    if(num[i] == n){
	        st.push(v[i]);
	        n--;
	    }
	    if(n == 0) break;
	}
	while(!st.empty()) {
	    cout << st.top() <<" ";
	    st.pop();
	}
}

