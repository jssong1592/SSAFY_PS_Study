import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		boolean flag = true;
		HashMap<Integer,Integer> parentOf = new HashMap<>();
		HashSet<Integer> nodes = new HashSet<>();
		HashSet<int[]> vertexes = new HashSet<>();
		while(true) {
			//�� �б�
			String line = br.readLine();
			
			String[] st = line.split("  ");
			
			for (String vertex:st) {
				if (vertex.equals("0 0")) {//���̽� �ϳ��� �������Ƿ� ��� ó�� �� �÷��� �ʱ�ȭ
					if (nodes.size()==0||(flag&&countRoot(nodes,parentOf)==1&&nodes.size()-vertexes.size()==1))
						System.out.println("Case "+(tc)+" is a tree.");
					else System.out.println("Case "+(tc)+" is not a tree.");
					
					//���̽� �ʱ�ȭ�ϰ� ���� �� �а� �Ѿ��
					tc++;
					
					flag = true;
					parentOf = new HashMap<>();
					nodes = new HashSet<>();
					vertexes = new HashSet<>();
					
					line = br.readLine();
					
					break;
				} else {
					StringTokenizer st2 = new StringTokenizer(vertex);
					int parent = Integer.parseInt(st2.nextToken());
					int child = Integer.parseInt(st2.nextToken());
					
					nodes.add(parent);
					nodes.add(child);
					vertexes.add(new int[] {parent,child});
					
					// ����) Ʈ���� ���
					// ��. ��尡 ��� Ʈ����
					// 1. ��Ʈ�� ��尡 �ϳ�
					// 2. ���� ���� - ���� ���� == 1
					// 3. ������ ������ ������ 2 �̻��� ��尡 �ִ���(child�� �θ� �̹� ����)
					if (parent==child||parentOf.get(child)!=null) {
						flag = false;
					} else {
						parentOf.put(child, parent);
					}
				}
			}
			
			//���̽� ������ ���� ���� ���� -1 -1�̸� ������ ������
			if (line.equals("-1 -1")) return;
			
		}
		

	}

	static int countRoot(HashSet<Integer> nodes, HashMap<Integer,Integer> parentOf) {
		int cnt = 0;
		for (int node:nodes) {
			if (parentOf.get(node)==null) cnt++;
		}
		return cnt;
	}

}
