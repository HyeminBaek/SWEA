import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution
{
	private static class Edge implements Comparable<Edge>{
		int x,y; double w;

		public Edge(int x, int y, double w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.w>o.w) return 1;
			else if(this.w==o.w) return 0;
			return -1;
		}
	}

	private static PriorityQueue<Edge> weight;
	private static int parent[];
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N= Integer.parseInt(br.readLine());
			ArrayList<Edge> list = new ArrayList<Edge>();
			
			
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {
				list.add(new Edge(Integer.parseInt(stx.nextToken()),Integer.parseInt(sty.nextToken()),0));
			}
			
			double E = Double.parseDouble(br.readLine()); //end of input
			
			weight = new PriorityQueue<Edge>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					
					double tmpx = (long)(list.get(i).x-list.get(j).x)*(long)(list.get(i).x-list.get(j).x);
					double tmpy = (long)(list.get(i).y-list.get(j).y)*(long)(list.get(i).y-list.get(j).y);
					weight.add(new Edge(i,j,E*(tmpx+tmpy)));
				}
			}//calculate weight
			
			parent = new int[N];
			for(int i=0;i<N;i++) parent[i]=i;
			
			sb.append("#"+test_case+" "+Math.round(makeMST(N))+"\n");
		}//tc
		
		System.out.println(sb);
	}//main
	private static double makeMST(int N) {
		double answer =0; int cnt=0;
		
		for(int i=0;;i++) {
			Edge e = weight.poll();
			if(Unionfind(e.x,e.y)) {
				answer += e.w;
				if(++cnt==N-1) break;
			}
		}
		
		return answer;
	}
	private static boolean Unionfind(int x,int y) {
		x = unionFind(x);
		y = unionFind(y);
		
		if(x==y) return false;
		
		parent[y]=x;
		
		return true;
	}
	private static int unionFind(int x) {
		if(parent[x]==x) return x;
		return parent[x]=unionFind(parent[x]);
	}
}
