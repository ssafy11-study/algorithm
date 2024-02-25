#include <cstdio>
#include <algorithm>
using namespace std;

int n, m;
int nums[8];
int arr[8];
int visit[8] = { 0 };

void DFS(int count) {
    int rest = m - count;

    if (rest == 0) {
        for (int i = 0; i < m; i++)
            printf("%d ", arr[i]);
        printf("\n");
        return;
    }

    for (int i = 0; i < n; i++) {
        if (rest != 0) {
            if (visit[i] == 0) {
                arr[count] = nums[i];
                visit[i] = 1;
                DFS(count + 1);
                visit[i] = 0;
            }
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);

    for (int i = 0; i < n; i++)
        scanf("%d", &nums[i]);

    sort(nums, nums + n);

    DFS(0);
    
    return 0;
}