#include <iostream>

using namespace std;
int N, r, c;
int result;

void divide_conq(int cr, int cc, int size)
{
    if (cr == r && cc == c)
    {
        cout << result << '\n';
        return;
    }

    // 현재 사분면에 존재
    if (r < cr + size && r >= cr && c < cc + size && c >= cc)
    {
        // 1
        divide_conq(cr, cc, size / 2);
        // 2
        divide_conq(cr, cc + size / 2, size / 2);
        // 3
        divide_conq(cr + size / 2, cc, size / 2);
        // 4
        divide_conq(cr + size / 2, cc + size / 2, size / 2);
    }
    else // 없으면 사분면 크기만큼 더해주고 버리기
    {
        result += size * size;
    }
}
int main()
{

    cin >> N >> r >> c;
    divide_conq(0, 0, pow(2,N));
    return 0;
}