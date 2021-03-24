#include<iostream>
#include <set>
#include <queue>
#include <string>
using namespace std;
 
int map[4][4];
set<string> s;
 
void bfs(int i, int j)
{
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
     
    queue<pair<pair<int,int>,string>> q;
    q.push({{i,j},to_string(map[i][j])});
     
    while(!q.empty())
    {
        int x = q.front().first.first,y=q.front().first.second;
        string a = q.front().second; q.pop();
         
        if(a.length()==7)
            s.insert(a);
        else
        {
            for(int k=0;k<4;k++)
            {
                int nx = x+dx[k], ny=y+dy[k];
                if(0<=nx&&nx<4&&0<=ny&&ny<4)
                {
                    string temp = a+to_string(map[nx][ny]);
                    q.push({{nx,ny},temp});
                }
            }
        }
    }
}
int main(int argc, char** argv)
{
    int test_case;
    int T;
  
    cin>>T;
    /*
       여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
    */
    for(test_case = 1; test_case <= T; ++test_case)
    {
        for(int i =0;i<4;i++)
        {
            for(int j =0;j<4;j++)
                cin>>map[i][j];
        }
        s.clear();
        for(int i =0;i<4;i++)
        {
            for(int j =0;j<4;j++)
                bfs(i,j);
        }
         
        cout<<"#"<<test_case<<" "<<s.size()<<"\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
