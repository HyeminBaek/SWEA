import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
class Solution
{
    //class for ps
    private static class Pair{
        int x,y;
 
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //global var for ps
    private static int N;
    private static int[][] arr;
    private static int dir[][] = {{-1,0},{0,1},{0,-1},{1,0}};
     
    public static void main(String args[]) throws Exception
    {
        //basic setting for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringBuilder sb = new StringBuilder();
         
        int T=Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i=0;i<N;i++) {
                String s = br.readLine();
                for(int j=0;j<N;j++)
                    arr[i][j]=s.charAt(j)-'0';
            }//input
             
            sb.append("#"+test_case+" "+bfs()+"\n");
        }
        System.out.println(sb);
    }//main
     
    private static int bfs() {
        int visited[][] = new int[N][N];
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) visited[i][j]=987654321;
         
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(0,0)); visited[0][0]=0;
         
        while(!q.isEmpty()) {
            int x = q.peek().x, y = q.peek().y; q.poll();
             
            for(int k=0;k<4;k++) {
                int nx = x+dir[k][0],ny=y+dir[k][1];
                 
                if(0<=nx&&nx<N&&0<=ny&&ny<N) {
                    if(visited[nx][ny]>visited[x][y]+arr[nx][ny]) {
                        visited[nx][ny]=visited[x][y]+arr[nx][ny];
                        q.offer(new Pair(nx,ny));
                    }
                }
            }
        }//while loop
         
        return visited[N-1][N-1];
    }
}
