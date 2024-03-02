#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;
    
    int arr[N+1];
    int totCnt=0;
    for(int i=0;i<N;i++){
        cin >>arr[i];
    }
    
    for(int i=0;i<N;i++){
        if (arr[i] < 2){
            continue;
        }
        int tempCnt = 0;
        for (int j=2;j<arr[i];j++){
            if ((arr[i] % j) == 0){
                tempCnt ++;
            }
        }
        if (tempCnt == 0){
            totCnt ++;
        }
    }
    
    cout << totCnt << endl;
    return 0;
}