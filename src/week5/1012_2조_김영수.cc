#include <cstdio>

void findAll(int map[50][50], int n, int m, int x, int y) {
    int dx[4] = { -1, 0, 1, 0 };
    int dy[4] = { 0, -1, 0, 1 };

    map[x][y] = 0;

    for (int i = 0; i < 4; i++)
        if (((x + dx[i]) >= 0) && ((x + dx[i]) < n) && ((y + dy[i]) >= 0) && ((y + dy[i]) < m))
            if (map[x + dx[i]][y + dy[i]] == 1)
                findAll(map, n, m, x + dx[i], y + dy[i]);
}

int find(int map[50][50], int n, int m) {
    int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (map[i][j] == 1) {
                findAll(map, n, m, i, j);
                count++;
            }
        }
    }

    return count;
}

int main() {
    int T, n, m, k;
    int map[50][50] = { 0 };

    scanf("%d", &T);

    for (int i = 0; i < T; i++) {
        scanf("%d%d%d", &n, &m, &k);

        for (int j = 0; j < k; j++) {
            int x, y;
            scanf("%d%d", &x, &y);
            map[x][y] = 1;
        }

        printf("%d\n", find(map, n, m));
    }
    
    return 0;
}