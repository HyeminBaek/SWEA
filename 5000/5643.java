import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Solution
{
    private static int N;
    private static int[] visitcnt;
    private static boolean[] visited;
    private static ArrayList<Integer>[] list;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
             
            list = new ArrayList[N+1];
            for(int i=1;i<=N;i++) list[i] = new ArrayList<Integer>();
             
            for(int i=0;i<M;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
                list[a].add(b);
            }
             
            visitcnt = new int[N+1];
             
            for(int i=1;i<=N;i++) {
                visited = new boolean[N+1]; visitcnt[i]+=1;dfs(i,i);
            }
             
            sb.append("#"+test_case+" "+count()+"\n");
        }//tc
         
        System.out.println(sb);
    }//main func
    private static void dfs(int x,int stp) {
     
        for(int i=0;i<list[x].size();i++) {
            int nx = list[x].get(i);
            if(!visited[nx]) {
                visited[nx] = true; visitcnt[nx]++; 
                visitcnt[stp]++; dfs(nx,stp);
            }
        }
    }
    private static int count() {
        int result =0;
         
        for(int i=1;i<=N;i++) {
            //System.out.println(visitcnt[i]);
            if(visitcnt[i]==N) result+=1;
        }
        return result;
    }
}
