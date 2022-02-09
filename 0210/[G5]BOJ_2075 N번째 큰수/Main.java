import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int findMaxStack(Stack<Integer>[] table) { // ���� ���� ū ���� �ִ� �ε��� ã��
		int max = Integer.MIN_VALUE;
		int maxIdx = Integer.MIN_VALUE;
		for (int i=0;i<table.length;i++) {
			if (table[i].peek()>max) {
				max = table[i].peek();
				maxIdx = i;
			}
		}
		System.out.println(table[maxIdx].toString());
		return maxIdx;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer>[] table = new Stack[N];
		
		for (int i=0;i<N;i++) {
			table[i] = new Stack<Integer>();
		}
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j=0;j<N;j++) {
				
				table[j].push(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i=0;i<N-1;i++) { // N-1�� pop�ؼ� N��° ū ������ ã�Ƴ���
			int idx = findMaxStack(table);
			table[idx].pop();
		}
		
		System.out.println(table[findMaxStack(table)].peek());
	}

}
