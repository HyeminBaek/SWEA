#include<iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T; cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N; cin>>N;
        vector<pair<int,string>> v;
        set<string> st;
        for(int i=0;i<N;i++)
        {
            string s; cin>>s;
            if(st.find(s)==st.end())
            {
                v.push_back({s.length(),s});
                st.insert(s);
            }
        }
        sort(v.begin(),v.end());
         
        cout<<"#"<<test_case<<"\n";
        for(int i=0;i<v.size();i++)
        {
            cout<<v[i].second<<"\n";
        }
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
