#include <cstdio>

void BFS(int n, int v, int list[100001], int list2[100001], int size, int index) {
    if (n == v)
        return;

    if (n > 0) {
        if (list[n - 1] == -1) {
            list2[size] = n - 1;
            size++;
            list[n - 1] = list[n] + 1;
        }
    }

    if (n < 100000) {
        if (list[n + 1] == -1) {
            list2[size] = n + 1;
            size++;
            list[n + 1] = list[n] + 1;
        }
    }

    if (n <= 50000) {
        if (list[2 * n] == -1) {
            list2[size] = 2 * n;
            size++;
            list[2 * n] = list[n] + 1;
        }
    }

    if (size > index)
        BFS(list2[index], v, list, list2, size, index + 1);
}

int main() {
    int n, m;
    int list[100001];
    int list2[100001];

    scanf("%d%d", &n, &m);

    for (int i = 0; i < 100001; i++)
        list[i] = -1;

    list[n] = 0;

    BFS(n, m, list, list2, 0, 0);

    printf("%d\n", list[m]);

    return 0;
}