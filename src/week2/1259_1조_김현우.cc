#include <iostream>
#include <string>

using namespace std;

int main(void){
    cin.tie(NULL);
    cout.tie(NULL);
    string s;
    getline(cin, s);
    while(s != "0"){
        int l = s.length()/2 , i;
        for(i = 0; i < l; i++){
            if(s[i] != s[s.length()-1-i]){
                cout << "no\n";
                break;
            }
            if(i ==l-1){
                cout << "yes\n";
            }
        }
        if(s.length() ==1){
            cout << "yes\n";
        }
        getline(cin,s);
    }
}