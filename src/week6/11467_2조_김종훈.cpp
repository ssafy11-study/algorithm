#include <iostream>
#include <vector>
using namespace std;

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    
    char B = '@', W = '.';
    int b, w; cin >> b >> w;
    
    if (b > w) {
        swap(b, w);
        swap(B, W);
    }
    
    vector<vector<char>> board(2 * w, vector<char>(2));
    
    for (int i = 0; i < 2 * w; i += 2) {
        board[i][0] = board[i][1] = B;
        board[i + 1][0] = board[i + 1][1] = W;
    }
    
    for (int i = 0; i < w - b; ++i) {
        board[1 + 2 * i][0] = B;
    }
    
    cout << 2 * w << ' ' << "2\n";
    for (int i = 0; i < board.size(); ++i) {
        cout << board[i][0] << board[i][1] << '\n';
    }
}