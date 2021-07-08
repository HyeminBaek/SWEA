#include<iostream>
#include <iomanip>
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;  cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N; cin>>N;
         
        double ans=0;
        for(N;N>0;N--)
        {
            double p,x; cin>>p>>x;
            ans+=p*x;
        }
        cout<<"#"<<test_case<<" "<<fixed<<setprecision(6)<<ans<<"\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
