#include<iostream>
#include <queue>
using namespace std;
 
int arr[10][10];
void snail(int size)
{
    int dx[] = { 0,1,0,-1 };
    int dy[] = { 1,0,-1,0 };
 
    arr[0][0] = 1;
 
    int cur = 2;
    queue<pair<pair<int, int>, int>> q; q.push({ { 0,0 },0 });
    while (cur <= size * size)
    {
        int x = q.front().first.first, y = q.front().first.second;
        int dir = q.front().second; q.pop();
 
        int nx = x + dx[dir], ny = y + dy[dir];
 
        if (0 > nx || nx >= size || 0 > ny || ny >= size ||arr[nx][ny]>0)
        {
            dir++; dir %= 4;
            nx = x + dx[dir], ny = y + dy[dir];
        }
        if (0 <= nx && nx<size && 0 <= ny && ny<size)
        {
            if (arr[nx][ny] == 0)
            {
                arr[nx][ny] = cur++;
                q.push({ { nx,ny },dir });
            }
        }
    }
}
int main(int argc, char** argv)
{
    int test_case;
    int T; cin >> T;
 
    for (test_case = 1; test_case <= T; ++test_case)
    {
        int size; cin >> size;
 
        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
                arr[i][j] = 0;
        }
 
        snail(size);
 
        cout << "#" << test_case << "\n";
        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
                cout << arr[i][j] << " ";
            cout << '\n';
        }
    }
    return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
