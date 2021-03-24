#include<iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
 
int N;
int dx[] = {0,0,1,-1};
int dy[]={1,-1,0,0};
int arr[100][100];
int visited[100][100];
void bfs()
{
    queue<pair<int,int>> q;
    q.push({0,0}); visited[0][0] =0;
     
    while(!q.empty())
    {
        int x = q.front().first,y=q.front().second; q.pop();
         
        for(int k =0;k<4;k++)
        {
            int nx = x+dx[k],ny=y+dy[k];
             
            if(0<=nx&&nx<N&&0<=ny&&ny<N)
            {
                if(visited[nx][ny]>visited[x][y]+arr[nx][ny])
                {
                    visited[nx][ny] = visited[x][y]+arr[nx][ny];
                    q.push({nx,ny});
                }
            }
        }
    }
}
int main(int argc, char** argv)
{
    int test_case;
    int T; cin>>T;
 
    for(test_case = 1; test_case <= T; ++test_case)
    {
        cin>>N;
        for(int i =0;i<N;i++)
        {
            for(int j =0;j<N;j++)
            {
                char c; cin>>c;
                arr[i][j] = c-'0';
                visited[i][j]=987654321;
            }
        }
        bfs();
        cout<<'#'<<test_case<<" "<<visited[N-1][N-1]<<"\n";
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
