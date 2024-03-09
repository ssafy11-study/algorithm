#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

struct info{
    int from,to;
    long long cost;
};

int N,M,W;
vector<info> v;
long long dist[501] = {0,};

int main(void){
    fastio;
    int T;
    cin >> T;
    for(int t = 0; t<T; t++){
        fill(dist,dist+501,987654321);
        v.clear();
        cin >> N >> M >> W;
        for(int i = 0; i < M; i++){
            info tmp;
            cin >> tmp.from >> tmp.to >> tmp.cost;
            v.push_back(tmp);
            swap(tmp.from,tmp.to);
            v.push_back(tmp);
        }
        for(int i = 0; i < W; i++){
            info tmp;
            cin >> tmp.from >> tmp.to >> tmp.cost;
            tmp.cost *= -1;
            v.push_back(tmp);
        }
        dist[1] = 0;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < v.size(); j++){
                if(dist[v[j].to] > dist[v[j].from] + v[j].cost) dist[v[j].to] = dist[v[j].from] + v[j].cost;
            }
        }
        int i = 0;
        for(i; i <= v.size(); i++){
            if(i == v.size())break;
            if(dist[v[i].to] > dist[v[i].from] + v[i].cost){
                cout << "YES\n";
                break;
            }
        }
        if(i == v.size())cout <<"NO\n";
    }
}