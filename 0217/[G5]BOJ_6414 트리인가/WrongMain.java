import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WrongMain {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		boolean flag = true;
		HashMap<Integer,Integer> parentOf = new HashMap<>();
		
		while(true) {
			//�� �б�
			String line = br.readLine();
			
			String[] st = line.split("  ");
			
			for (String vertex:st) {
				if (vertex.equals("0 0")) {//���̽� �ϳ��� �������Ƿ� ��� ó�� �� �÷��� �ʱ�ȭ
					if (parentOf.size()==0||(flag&&countRoot(parentOf)==1))System.out.println("Case "+(tc)+" is a tree.");
					else System.out.println("Case "+(tc)+" is not a tree.");
					
					//���̽� �ʱ�ȭ�ϰ� ���� �� �а� �Ѿ��
					tc++;
					parentOf = new HashMap<>();
					line = br.readLine();
					flag = true;
					
					break;
				} else {
					StringTokenizer st2 = new StringTokenizer(vertex);
					int parent = Integer.parseInt(st2.nextToken());
					int child = Integer.parseInt(st2.nextToken());
					// Ʈ���� �ƴ� ���
					// 1. parent�� child�� ���� ��
					// 2. child�� �θ� �̹� ������ ��
					// 3. ��尡 ��ȯ�� ��(������ �ڽ����� ������� �� ��)
					// 4. ��Ʈ ��尡 2�� �̻��� ��
					if (parent==child||parentOf.get(child)!=null||isAncestor(child,parent,parentOf)) {
						flag = false;
					} else {
						parentOf.put(child, parent);
					}
				}
			}
			
			//���̽� ������ ���� ���� ���� -1 -1�̸� ������ ������
			if (line.equals("-1 -1")) break;
			
		}
		

	}
	
	static boolean isAncestor(int child, int parent, HashMap<Integer,Integer> parentOf) {
		while(parentOf.get(parent)!=null) {
			if (parentOf.get(parent)==child) {
				return true;
			}
			parent = parentOf.get(parent);
			
		}
		return false;
	}
	
	static int countRoot(HashMap<Integer,Integer> parentOf) {
		int cnt = 0;
		int root = -1;
		for(Integer child:parentOf.keySet()) {
			int parent = parentOf.get(child);
			while(parentOf.get(parent)!=null) {
		
				parent = parentOf.get(parent);
				
			}
			if (root!=parent) {
				root = parent;
				cnt++;
			}
		}
		return cnt;
	}

}
