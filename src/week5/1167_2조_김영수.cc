#include <cstdio>
#include <vector>
using namespace std;

struct line {
    int node;
    int cost;
};

int result = 0, fnode;
vector<line> lines[100000];
int  visit[100000] = { 0 };

void DFS(int node, int cost) {
    if (result < cost) {
        result = cost;
        fnode = node;
    }

    for (int i = 0; i < lines[node].size(); i++) {
        line temp = lines[node][i];
        if (visit[temp.node] == 0) {
            visit[temp.node] = 1;
            DFS(temp.node, cost + temp.cost);
            visit[temp.node] = 0;
        }
    }
}

int main() {
    int n;

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        int startnode;

        scanf("%d", &startnode);

        while (1) {
            int node, cost;
            line templine;

            scanf("%d", &node);

            if (node == -1)
                break;

            scanf("%d", &cost);

            templine.node = node - 1;
            templine.cost = cost;

            lines[startnode - 1].push_back(templine);
        }
    }

    visit[0] = 1;
    DFS(0, 0);
    visit[0] = 0;
    visit[fnode] = 1;
    DFS(fnode, 0);

    printf("%d\n", result);

    return 0;
}