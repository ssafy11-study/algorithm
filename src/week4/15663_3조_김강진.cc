#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n,m,tmp,res[8];
vector<int> arr;
bool check[8];

void func(int idx, vector<int> arr){
    if (idx == m){
        for (int i=0;i<m;i++){
            cout << res[i] << ' ';
        }
        cout << endl;
        return;
    }
    int prev = 0;
    for (int i =0;i<n;i++){
        if(!check[i] && arr[i] != prev){
            res[idx] = arr[i];
            prev = arr[i];
            check[i] = true;
            func(idx+1, arr);
            check[i] = false;
        }
    }
}

int main()
{
	cin >> n >> m;
	for(int i=0;i<n;i++){
	    cin >> tmp;
	    arr.push_back(tmp);
	}
	
    sort(arr.begin(),arr.end());
    
    func(0, arr);
    
    return 0;
}
