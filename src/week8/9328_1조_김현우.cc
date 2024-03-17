#include <iostream>
#include <queue>
#include <algorithm>
#include <tuple>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int N,M;
int dy[4] = {-1,1,0,0}, dx[4] = {0,0,-1,1};
char map[102][102];
bool key[26];
bool visited[102][102];

int main(void){
    fastio;
    int T;
    string s;
    cin >> T;
    for(int t = 0; t < T; t++){
        fill(&map[0][0],&map[101][101],'.');
        fill(&visited[0][0], &visited[101][101],false);
        fill(key,key+26,false);
        cin >> N >> M;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> map[i][j];
                if(map[i][j] == '*')visited[i][j] = true;
            }
        }
        cin >> s;
        if(s != "0"){
            for(int i = 0; i < s.length(); i++){
                key[s[i]-97]= true;
            }
        }
        queue<pair<int,int>> q;
        queue<tuple<int,int,int>> door;
        q.push({0,0});
        int result = 0;
        while(!q.empty()){
            pair<int,int> tmp = q.front();
            q.pop();
            for(int d = 0; d < 4; d++){
                int ny = tmp.first+dy[d], nx = tmp.second+dx[d];
                if(ny<0||nx <0 ||ny > N+1 ||nx>M+1||visited[ny][nx])continue;
                visited[ny][nx] = true;
                if(65<=(int)map[ny][nx]&&(int)map[ny][nx]<=90){
                    if(key[(int)map[ny][nx]-65]){
                        q.push({ny,nx});
                    }else{
                        door.push({(int)map[ny][nx]-65,ny,nx});
                    }
                }
                else if(97<=(int)map[ny][nx]&&(int)map[ny][nx]<=122){
                    key[(int)map[ny][nx]-97]= true;
                    int doorIdx = door.size();
                    for(int i = 0; i < doorIdx; i++){
                        tuple<int,int,int> tmp2 = door.front();
                        door.pop();
                        if(key[get<0>(tmp2)]){
                            q.push({get<1>(tmp2),get<2>(tmp2)});
                        }else{
                            door.push(tmp2);
                        }
                        q.push({ny,nx});
                    }
                }else{
                    if(map[ny][nx] == '$')result++;
                    q.push({ny,nx});
                }
            }
        }
        cout << result <<"\n";
    }
}