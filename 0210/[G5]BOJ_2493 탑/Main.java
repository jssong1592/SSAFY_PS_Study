import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<int[]> stack = new Stack<>();
		for (int i=0;i<N;i++) {
			int T = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) sb.append("0 ");
			
			else {
				while(!stack.isEmpty()&&stack.peek()[1]<T) {
					stack.pop();
				}
				if (stack.isEmpty()) sb.append("0 ");
				else {
					sb.append(stack.peek()[0]+" ");
				}
			}
			
			stack.push(new int[] {i+1,T});
			
		}
		System.out.println(sb);
	}

}
