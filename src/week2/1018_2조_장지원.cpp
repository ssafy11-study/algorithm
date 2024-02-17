#include <iostream>
#include <vector>
using namespace std;

int N;
vector<pair<char,char>> v(26);

void preOrder(char c){
    cout << c ;
    
    if(v[c-'A'].first != '.')
        preOrder(v[c-'A'].first);
        
    if(v[c-'A'].second != '.')
        preOrder(v[c-'A'].second);
}

void inOrder(char c){
    if(c == '.')
        return;
        
    inOrder(v[c-'A'].first);
    cout << c;
    inOrder(v[c-'A'].second);
}

void postOrder(char c){
    if(c == '.')
        return;
    postOrder(v[c-'A'].first);
    postOrder(v[c-'A'].second);
    cout << c;
}

int main(){
    
    cin >> N;

    for(int i=0; i<N; i++){
        char node, left, right;
        cin >> node >> left >> right;
        
        int idx = node - 'A';
        v[idx] = {left, right};
    }
    
    preOrder('A');
    cout << "\n";
        
    inOrder('A');
    cout << "\n";
        
    postOrder('A');

    return 0;
}
