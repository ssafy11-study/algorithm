#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
    int n, m, arr[100000];

    scanf("%d", &n);
    for (int i = 0; i < n; i++)
        scanf("%d", arr+i);

    sort(arr, arr + n);

    scanf("%d", &m);
    for (int i = 0; i < m; i++) {
        int left = 0, right = n - 1;
        int temp, j = 0;
        scanf("%d", &temp);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (temp < arr[mid])
                right = mid - 1;
            else if (temp > arr[mid])
                left = mid + 1;
            else {
                printf("1\n");
                break;
            }
        }
        if (left > right)
            printf("0\n");
    }
    
    return 0;
}