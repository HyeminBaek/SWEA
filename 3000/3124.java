import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution
{
	private static class Edge implements Comparable<Edge>{
		int u,v,w;
	
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	
		@Override
		public int compareTo(Edge o) {
			if(this.w < o.w) return -1;
			else if(this.w == o.w) return 0;
			return 1;
		}
	}
	private static int uf[];
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()),E=Integer.parseInt(st.nextToken());
			
			Edge e[]=new Edge[E];
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int sp = Integer.parseInt(st.nextToken()),ep=Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				
				e[i]=new Edge(sp-1,ep-1,val);
			}

			Arrays.sort(e);
			
			uf = new int[V];
			for(int i=0;i<V;i++) uf[i]=i;
			
			long result=0,cnt=0;
			for(int i=0;;i++) {
				if(union(e[i].u,e[i].v)) {
					result+=e[i].w;
					if(++cnt==V-1) break;
				}
			}
			
			sb.append("#"+test_case+" "+result+"\n");
		}//tc
		System.out.println(sb);
	}//main
	private static boolean union(int a,int b) {
		a=find(a);
		b=find(b);
		
		if(a==b) return false;
		uf[b]=a;
		
		return true;
	}
	private static int find(int a) {
		if(uf[a]==a) return a;
		return uf[a]=find(uf[a]);
	}
}
