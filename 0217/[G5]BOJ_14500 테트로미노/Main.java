import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int maxResult = 0;
		int[][] map = new int[N+6][M+6];
		
		for (int i=3;i<N+3;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=3;j<M+3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i=3;i<N+3;i++) {
			for (int j=3;j<M+3;j++) {
				//1�� ���(����)
				int result = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				if (result>maxResult) maxResult = result;
				//1�� ���(����)
				result = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				if (result>maxResult) maxResult = result;
				//���簢��
				result = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
				if (result>maxResult) maxResult = result;
				//��
				result = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
				if (result>maxResult) maxResult = result;
				//��
				result = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
				if (result>maxResult) maxResult = result;
				//��
				result = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
				if (result>maxResult) maxResult = result;
				//��
				result = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+1][j];
				if (result>maxResult) maxResult = result;
				//��(ª�� ������ ��ŸƮ)
				result = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
				if (result>maxResult) maxResult = result;
				//��(�ð�90��)
				result = map[i][j] + map[i][j-1] + map[i+1][j-1] + map[i+2][j-1];
				if (result>maxResult) maxResult = result;
				//��(�ð�180��)
				result = map[i][j] + map[i-1][j] + map[i-1][j-1] + map[i-1][j-2];
				if (result>maxResult) maxResult = result;
				//��(�ð�270��)
				result = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-2][j+1];
				if (result>maxResult) maxResult = result;
				//��(���ΰſ����)
				result = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+1][j-2];
				if (result>maxResult) maxResult = result;
				//��(�ð�90��)
				result = map[i][j] + map[i][j-1] + map[i-1][j-1] + map[i-2][j-1];
				if (result>maxResult) maxResult = result;
				//��(�ð�180��)
				result = map[i][j] + map[i-1][j] + map[i-1][j+1] + map[i-1][j+2];
				if (result>maxResult) maxResult = result;
				//��(�ð�270��)
				result = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				if (result>maxResult) maxResult = result;
				//��1
				result = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
				if (result>maxResult) maxResult = result;
				//��2
				result = map[i][j+1] + map[i+1][j+1] + map[i+1][j] + map[i+2][j];
				if (result>maxResult) maxResult = result;
				//��3
				result = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
				if (result>maxResult) maxResult = result;
				//��4
				result = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
				if (result>maxResult) maxResult = result;
			}
		}
		
		System.out.println(maxResult);
	}

}
