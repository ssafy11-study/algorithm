#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    while(1){
        int N, W;
        cin >> N >> W;
        if(N == 0 && W == 0) {
            break;
        }
        
        vector<int> v;
        
        for(int i=0; i<N; i++){
            int n;  cin >> n;
            v.push_back(n);
        }
        
        sort(v.begin(), v.end());
        
        
        //  구간 만들기
        vector<pair<int,int>> section;
        int maxNum = *(v.end()-1);
        
        int start = 0;
        int end = W-1;
        while(end < maxNum + W){
            section.push_back({start, end});
            start = end +1;
            end += W;
        }
        
        // 각 구간별 숫자 개수 세기
        vector<int> sectionCount(section.size());
        
        for(int i=0; i<N; i++){
            for(int j=0; j<section.size(); j++){
                if(section[j].first <= v[i] && v[i] <= section[j].second){
                    sectionCount[j] += 1;
                    break;
                }
            }
        }
        
        // 높이가 가장 높은 구간 인덱스
        int highestIdx = max_element(sectionCount.begin(), sectionCount.end()) - sectionCount.begin();
        // 높이가 가장 높은 구간의 숫자 개수
        int highest = *max_element(sectionCount.begin(), sectionCount.end());
        
        double sum = 0;
        
        for(int i=0; i<section.size(); i++){
            double bright;
            double cnt;
            
            // i == highestIdx
            if(sectionCount[i] == highest)  // || sectionCount[i] == highest
                cnt = 1;
            else 
                cnt = ((double)sectionCount[i] / highest);

            bright = 1 - ((double)i/(section.size() - 1));
            sum += cnt * bright;
        }
        sum += 0.01;
        cout.precision(10);
        cout << sum << "\n";
    }
    
    return 0;
}
