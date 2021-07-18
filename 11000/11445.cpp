#include<iostream>
#include <string>
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T; cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        string P,Q; cin>>P>>Q;
         
        bool flag = true;
        if(P[0]==Q[0]) {
            if(P.length()<Q.length()) {
                string s = Q.substr(0,P.length());
                 
                if(P==s) {
                    s="";
                    for(int i = P.length();i<Q.length();i++)
                        s+=Q[i];
                     
                    if(s.length()==1&&s[0]=='a') flag = false;
                }
            }
        }
        else {
            if(P.length()==1&&Q.length()==1) {
                char cp = P[0],cq=Q[0];
                 
                if(cq-cp==1) flag = false;
            }
        }
         
        cout<<"#"<<test_case<<" ";
        if(flag) cout<<"Y\n";
        else cout<<"N\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
