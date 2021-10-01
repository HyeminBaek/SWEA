import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    private static int[][] arr;
    private static int N;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
             
            arr=new int[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(arr[i][j]==0) arr[i][j]=987654321;
                }
            }//input
             
            sb.append("#"+test_case+" ");
            sb.append(solution()+"\n");
        }//tc
        System.out.println(sb);
    }//main
    private static int solution() {
        for(int k=0;k<N;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++)
                    arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
            }
        }
         
        int min =987654321;
        for(int i=0;i<N;i++) {
            int sum=0;
            for(int j=0;j<N;j++) {
                if(i==j) continue;
                sum+=arr[i][j];
            }
            min = Math.min(sum, min);
        }
         
        return min;
    }
}
