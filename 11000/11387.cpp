#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;  cin>>T;
     
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int D,L,N; cin>>D>>L>>N;
         
        int answer =0;
        for(int i=0;i<N;i++)
        {
            answer+=D*(1+i*0.01*L);
        }
         
        cout<<"#"<<test_case<<" "<<answer<<"\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
