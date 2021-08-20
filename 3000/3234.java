import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    private static int cnt;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N= Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int[] list = new int[N];
 
            for(int i=0;i<N;i++) {
                list[i]=Integer.parseInt(st.nextToken());
            }//input
             
            cnt=0;
            boolean visited[] = new boolean[N]; 
            sol(0,0,0,N,visited,list);
            sb.append("#"+test_case+" "+cnt+"\n");
        }//test_case
        System.out.println(sb);
    }//main
 
    private static void sol(int idx,int right,int left,int N,boolean visited[],int[] list) {
        if(idx==N) {
            cnt++;
            return;
        }
         
        for(int k=0;k<N;k++) {
            if(!visited[k]) {
                visited[k]=true;
                 
                if(right+list[k]<=left) {//오른쪽 위에 올라가 있는 무게의 총합이 왼쪽에 올라가 있는 무게의 총합보다 더 커져서는 안 된다.
                    sol(idx+1,right+list[k],left,N,visited,list);
                }
                sol(idx+1,right,left+list[k],N,visited,list);
                visited[k]=false;
            }
        }
    }//sol
     
}
