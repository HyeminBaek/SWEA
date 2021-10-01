import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
/*
 * 1. 맨홀 뚜껑을 통해 지하터널의 어느 한 지점 -> 맨홀 위치에서 시작
 */
class Solution
{
   //class for ps
   private static class Pair{
      int x,y,time;
 
      public Pair(int x, int y, int time) {
         this.x = x;
         this.y = y;
         this.time = time;
      }
   }
   //global var for ps
   private static int M,N,R,C,L;
   private static int[][] arr;
   private static int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};
    
   public static void main(String args[]) throws Exception
   {
      //basic setting for input
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
       
      int T=Integer.parseInt(br.readLine());   
      for(int test_case = 1; test_case <= T; test_case++)
      {
         StringTokenizer st = new StringTokenizer(br.readLine());
         M=Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
         R=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken());
         L=Integer.parseInt(st.nextToken());
          
         arr = new int[M][N];
         for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
               arr[i][j]=Integer.parseInt(st.nextToken());
         }//input arr 
          
         sb.append("#"+test_case+" "+bfs()+"\n");
      }//tc
      System.out.println(sb);
   }
    
   private static int bfs() {
      Queue<Pair> q = new LinkedList<Pair>();
      q.offer(new Pair(R,C,0));
       
      boolean visited[][] = new boolean[M][N];
      visited[R][C]=true;
      while(!q.isEmpty()) {
         int x = q.peek().x,y=q.peek().y,time=q.peek().time; q.poll();
          
         if(time==L-1) break;
          
         int stp =0,edp=3,inc=1;
         //dir 위 오 왼 아
         switch(arr[x][y]) {
         case 2: //위0  아3
            inc=3; break;
         case 3://오1 왼2
            stp=1;edp=2; break;
         case 7://위0 왼2
            edp=2; inc=2; break;
         case 6://왼2 아3
            stp=2;edp=3; break;
         case 5://오1 아3
            stp=1; edp=3; inc=2; break;
         case 4://위0 오1
            edp=1; break;
         }//switch
          
         for(int k=stp;k<=edp;k+=inc) {
            if(chk(x,y,k,visited)) {
               int nx = x+dir[k][0],ny=y+dir[k][1];
               visited[nx][ny]=true;
               q.offer(new Pair(nx,ny,time+1));
            }
         }
      }
       
      return count(visited);
   }//bfs func
   private static boolean chk(int x,int y,int d,boolean visited[][]) {
      int nx = x+dir[d][0],ny = y+dir[d][1];
       
      if(0<=nx&&nx<M&&0<=ny&&ny<N&&!visited[nx][ny]&&arr[nx][ny]!=0) {
         //up
         if(d==0&&(arr[nx][ny]!=3&&arr[nx][ny]!=4&&arr[nx][ny]!=7)) return true;
         //right
         if(d==1&&(arr[nx][ny]!=2&&arr[nx][ny]!=4&&arr[nx][ny]!=5)) return true;
         //left
         if(d==2&&(arr[nx][ny]!=2&&arr[nx][ny]!=6&&arr[nx][ny]!=7)) return true;
         //down
         if(d==3&&(arr[nx][ny]!=3&&arr[nx][ny]!=5&&arr[nx][ny]!=6)) return true;
      }
      return false;
   }//chk func
   private static int count(boolean visited[][]){
      int cnt =0;
       
      for(int i=0;i<M;i++) {
         for(int j=0;j<N;j++)
            if(visited[i][j]) cnt+=1;
      }
       
      return cnt;
   }
}
