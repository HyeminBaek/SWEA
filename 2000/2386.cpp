#include<iostream>
#include <set>
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;  cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N; cin>>N;
         
        set<int> s;
        for(int i=0;i<N;i++)
        {
            int A; cin>>A;
            if(s.find(A)==s.end()) s.insert(A);
            else s.erase(A);
        }
        cout<<"#"<<test_case<<" "<<s.size()<<"\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
