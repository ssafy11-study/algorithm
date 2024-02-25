#include <cstdio>
#include <algorithm>
using namespace std;

struct point {
    int x;
    int y;
};

bool cmp(point a, point b) {
    if(a.x == b.x)
        return a.y<b.y;
    return a.x<b.x;
}

int main() {
    int n;
    point *p;
    
    scanf("%d", &n);
    p = new point[n];
    
    for(int i=0; i<n; i++)
        scanf("%d%d", &p[i].x, &p[i].y);
    
    sort(p, p+n, cmp);
    
    for(int i=0; i<n; i++)
        printf("%d %d\n", p[i].x, p[i].y);
    
    return 0;
}