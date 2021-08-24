import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Solution
{
	private static int[] parents;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb= new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()),M=Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			for(int i=1;i<=N;i++) parents[i]=i;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
				Unionfind(x,y);
			}
			
			sb.append("#"+test_case+" "+solution(N)+"\n");
		}//tc
		System.out.println(sb);
	}//main
	private static int solution(int N) {
		for(int i=1;i<=N;i++) Unionfind(i,parents[i]);

		Set<Integer> set = new HashSet<Integer>();
		for(int i=1;i<=N;i++) set.add(parents[i]);
		
		return set.size();
	}
	private static int unionFind(int x) {
		if(parents[x]==x) return x;
		return parents[x]=unionFind(parents[x]);
	}
	private static boolean Unionfind(int x,int y) {
		x = unionFind(x);
		y= unionFind(y);
		if(x==y) return false;
		parents[y]=x;
		return true;
	}
	
}
