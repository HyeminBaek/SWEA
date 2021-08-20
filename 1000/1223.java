import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution
{
	private static StringBuilder post;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('+', 0); map.put('-', 0); map.put('*', 1); map.put('/', 1);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			post = new StringBuilder();
			midToPost(map,s);
			
			sb.append("#"+test_case+" "+calculate()+"\n");
		}//test_case
		System.out.println(sb);
	}//main
	
	private static void midToPost(Map<Character,Integer> map, String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
				post.append(s.charAt(i));
			} else {
				char oper = s.charAt(i);
				
				while(true) {
					if(!stack.empty()&&map.get(stack.peek())>=map.get(oper)) {
						post.append(stack.pop());
					} else {
						stack.push(oper); break;
					}
				}//while
			}
		}//for
		
		while(!stack.isEmpty()) {
			post.append(stack.pop());
		}
	}//mid2post
	private static int calculate() {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<post.length();i++) {
			if(post.charAt(i)>='0'&&post.charAt(i)<='9') {
				stack.push(post.charAt(i)-'0');
			} else {
				char oper = post.charAt(i);
				int second = stack.pop(), first= stack.pop();
				switch(oper) {
				case '+':
					first +=second; break;
				case '-':
					first-=second; break;
				case '*':
					first*=second; break;
				case '/':
					first/=second; break;
				}
				stack.push(first);
			}
		}
		
		return stack.peek();
	}//calculate
	
}
