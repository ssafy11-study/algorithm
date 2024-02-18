#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int long N,S,tgt[41], counts = 0;
vector<int> lefts,rights;
vector<long long>leftsum, rightsum;

void combleft(int tgtIdx,int tgtSize, int next){
    if(tgtIdx == tgtSize){
        int sum = 0;
        for(int i = 0; i < tgtSize; i++){
            sum += tgt[i];
        }
        if(sum == S)counts++;
        leftsum.push_back(sum);
        return;
    }
    for(int i = next; i<lefts.size(); i++){
        tgt[tgtIdx] = lefts[i];
        combleft(tgtIdx+1,tgtSize,i+1);
    }
}

void combright(int tgtIdx,int tgtSize, int next){
    if(tgtIdx == tgtSize){
        int sum = 0;
        for(int i = 0; i < tgtSize; i++){
            sum += tgt[i];
        }
        if(sum == S)counts++;
        rightsum.push_back(sum);
        return;
    }
    for(int i = next; i<rights.size(); i++){
        tgt[tgtIdx] = rights[i];
        combright(tgtIdx+1,tgtSize,i+1);
    }
}

int main(void){
    fastio;
    int tmp;
    cin >> N >> S;
    for(int i = 0; i < N/2; i++){
        cin >> tmp;
        lefts.push_back(tmp);
    }
    for(int i = N/2; i < N; i++){
        cin >> tmp;
        rights.push_back(tmp);
    }
    sort(lefts.begin(),lefts.end());
    sort(rights.begin(),rights.end());
    for(int i = 1; i <=lefts.size(); i++){
        combleft(0,i,0);
    }
    for(int i = 1; i <=rights.size(); i++){
        combright(0,i,0);
    }
    int li = 0, ri = rightsum.size()-1;
    sort(leftsum.begin(),leftsum.end());
    sort(rightsum.begin(),rightsum.end());
    for(int i = 0; i < leftsum.size(); i++){
        int s = S-leftsum[i];
        if(binary_search(rightsum.begin(),rightsum.end(),s)){
            counts+= upper_bound(rightsum.begin(),rightsum.end(),s)-lower_bound(rightsum.begin(),rightsum.end(),s);
        }
    }
    cout << counts;
}


