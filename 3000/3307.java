
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{	
	private static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T =Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			sb.append("#"+test_case+" ");
			solution(N,arr);
			sb.append("\n");
		}//tc
		System.out.println(sb);
	}//main
	private static void solution(int N,int[] arr) {
		int answer =0;
		int[] dp = new int[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) dp[i] = Math.max(dp[i],dp[j]+1);
			}
			answer =Math.max(answer, dp[i]);
		}
		sb.append(answer+1);
	}
}
