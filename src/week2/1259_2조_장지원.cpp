#include <iostream>
using namespace std;

int main(){
    
    while(1){
        string n;  cin >> n;
        if(n == "0")  return 0;
        
        int len = n.length();
        
        bool flag = false;
        
        
        for(int i=0; i<len/2; i++){
            if(n[i] != n[len-1-i]){
                flag = true;
                break;
            }
        }
        
        
        if(flag)
            cout << "no\n";
        else
            cout << "yes\n";
    }
    
    
    return 0;
}
