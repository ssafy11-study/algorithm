#include <iostream>
#include <deque>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    deque<int> dq;
    int N, tmp;
    string s;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> s;
        if(s == "push_front"){
            cin >> tmp;
            dq.push_front(tmp);
        }
        else if(s == "push_back"){
            cin >> tmp;
            dq.push_back(tmp);
        }
        else if(s == "pop_front"){
            if(dq.empty()) cout << -1 << "\n";
            else{
                cout << dq.front() << "\n";
                dq.pop_front();
            }
        }
        else if(s == "pop_back"){
            if(dq.empty()) cout << -1 << "\n";
            else{
                cout << dq.back() << "\n";
                dq.pop_back();
            }
        }
        else if(s == "size"){
            cout << dq.size() << "\n";
        }
        else if(s == "empty"){
            if(dq.empty())cout <<1 << "\n";
            else cout << 0 << "\n";
        }
        else if(s == "front"){
            if(dq.empty())cout << -1 << "\n";
            else cout << dq.front() << "\n";
        }
        else {
            if(dq.empty())cout << -1 << "\n";
            else cout << dq.back() << "\n";
        }
    }
}