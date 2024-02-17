#include <iostream>
#include <queue>
#include <tuple>

#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int map[10][10];
int dy[4] = { -1,0,1,0 }, dx[4] = { 0,1,0,-1 };

int main(void) {
	fastio;
	int N, M, By, Bx, Ry, Rx;
	char c;
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> c;
			switch (c) {
			case '#':
				map[i][j] = -1;
				break;
			case 'B':
				By = i;
				Bx = j;
			case '.':
				map[i][j] = 0;
				break;
			case 'R':
				Ry = i;
				Rx = j;
				map[i][j] = 0;
				break;
			case 'O':
				map[i][j] = 1;
			}
		}
	}
	queue <tuple<pair<int, int>, pair<int, int>, int>> q;
	q.push({ {Ry,Rx},{By,Bx},0 });
	while (!q.empty()) {
		int ry = get<0>(q.front()).first, rx = get<0>(q.front()).second, by = get<1>(q.front()).first, bx = get<1>(q.front()).second, count = get<2>(q.front());
		q.pop();
		for (int i = 0; i < 4; i++) {
		    int rdy = ry, rdx = rx, bdy = by, bdx = bx, rflag = 0, bflag = 0;
		    while(map[rdy+dy[i]][rdx+dx[i]] != -1 || map[bdy+dy[i]][bdx+dx[i]] != -1){
		        if(map[rdy+dy[i]][rdx+dx[i]] == 1) {
		            rflag = 1;
		        }
		        if(map[bdy+dy[i]][bdx+dx[i]] == 1) {
		            bflag = 1;
		        }
		        if (map[rdy+dy[i]][rdx+dx[i]] != -1 && map[bdy+dy[i]][bdx+dx[i]] == -1 && rdy + dy[i] == bdy && rdx +dx[i] == bdx){
		           break; 
		        }
		        else if (map[rdy+dy[i]][rdx+dx[i]] == -1 && map[bdy+dy[i]][bdx+dx[i]] != -1 && rdy == bdy + dy[i]  && rdx == bdx+dx[i] ){
		           break; 
		        }else if(map[rdy+dy[i]][rdx+dx[i]] == -1){
		            bdy = bdy + dy[i];
		            bdx = bdx + dx[i];
		        }else if(map[bdy+dy[i]][bdx+dx[i]] == -1){
		            rdy = rdy + dy[i];
		            rdx = rdx + dx[i];
		        }else{
		            rdy = rdy + dy[i];
		            rdx = rdx + dx[i];
		            bdy = bdy + dy[i];
		            bdx = bdx + dx[i];
		        }
		    }
		    if(bflag == 1 || count == 10) continue;
		    else if(rflag == 1) {
		        cout << count+1;
		        return 0;
		    }
			if(ry == rdy && rx == rdx && by == bdy && bx == bdx) continue;
			else if (count == 10) continue;
			else {
			    q.push({ {rdy,rdx},{bdy,bdx},count + 1 });
			}
		}
	}
	cout << -1;
}
