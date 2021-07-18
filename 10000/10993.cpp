#include<iostream>
#include <vector>
#include <algorithm>
using namespace std;
 int uf[1001];
struct country
{
    int x,y,s;
};
void sol(vector<country> v,int k);
int Union(int);
int main(int argc, char** argv)
{
    int test_case;
    int T;  cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        int N; cin>>N;
         
        vector<country> v;
        for(int i=0;i<N;i++)
        {
            int x,y,s; cin>>x>>y>>s;
            v.push_back({x,y,s});
        }
          
 
         
        for(int i=0;i<N;i++) uf[i]=i;
             
        for(int i=0;i<v.size();i++)   sol(v,i);
    
        cout<<"#"<<test_case<<" ";
        for(int i=0;i<N;i++)
        {
            if(uf[i]==i) cout<<"K ";
            else if(uf[i]==-1) cout<<"D ";
            else
            {
                uf[i] = Union(i);
                cout<<uf[i]+1<<" ";
            }
        }
        cout<<"\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
int Union(int i)
{
    if(i==uf[i]) return uf[i];
     
    Union(uf[i]);
}
void sol(vector<country> v,int k)
{
    //si / ( (xj - xi)2+(yj - yi)2 )
    int cnt =0, mxc = 0, mxi=-1;
    double mxv=0;
    for(int i=0;i<v.size();i++)
    {
        if(i==k) continue;
         
        int cx = pow(v[i].x-v[k].x,2);
        int cy= pow(v[i].y-v[k].y,2);
         
        double cs = (double)v[i].s / (cx+cy);
 
        if(cs>v[k].s)
        {
            cnt+=1;
             
            if(mxv<cs)
            {
                mxv=cs; mxc=1; mxi=i;
            }
            else if(mxv==cs) mxc+=1;    
        }
    }
     
    if(cnt !=0)
    {
        if(mxc==1) uf[k] = mxi;
        else uf[k]=-1;
    }
}
