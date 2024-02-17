#include <iostream>
#include <queue>
#define fastio cin.tie(0)->ios_base::sync_with_stdio

using namespace std;

int main(void){
    fastio;
    int N, tmp;
    string s;
    queue <int> q;
    cin >> N;
    for(int i = 0; i< N; i++){
        cin >> s;
        if(s =="push"){ 
            cin >> tmp; 
            q.push(tmp);
        }
        else if(s =="pop"){
            if(q.empty()){
                cout << -1 << "\n";
            }
            else{
                cout << q.front() <<"\n";
                q.pop();
            }
        }
        else if(s =="size"){
            cout << q.size()<< "\n";
        }
        else if(s =="empty"){
            if(q.empty()) cout << 1 << "\n";
            else cout << 0 << "\n";
        }
        else if(s == "front"){
            if(q.empty()) cout << -1 << "\n";
            else cout << q.front() << "\n";
        }
        else{
            if(q.empty()) cout << -1 << "\n";
            else cout << tmp << "\n";
        }
    }
}