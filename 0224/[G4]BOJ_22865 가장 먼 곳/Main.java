package BOJ.G4.BOJ_22865_����հ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Pair>[] adjList;
	static int N;
	static int[] friends;
	
	static class Pair implements Comparable<Pair> {
		int node, distance;
		
		public Pair(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Pair o) {
			if (this.distance == o.distance) return this.node - o.node;
			return this.distance-o.distance;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		friends = new int[] {A,B,C};
		
		adjList = new ArrayList[N+1];
		for (int i=0;i<N+1;i++) adjList[i] = new ArrayList<Pair>();
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Pair(to,dist));
			adjList[to].add(new Pair(from,dist));
		}
		
		
		// �� ģ���� ���Ͽ� 1~N�� ������ �� 3�� ���ͽ�Ʈ�� ������ ������ �ּҰ� ���� 
		int[] result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		for (int i=0;i<3;i++) {
			int[] distance = dijkstra(friends[i]);
//			System.out.println(Arrays.toString(distance));
			for (int j=1;j<N+1;j++) {
				result[j] = Math.min(result[j], distance[j]);
			}
		}
		
//		System.out.println(Arrays.toString(result));
		
		// �ּҰ����� ���ŵ� ���� �߿��� �ִ밪�� ���� ���� Ž�� -> ���� �� ��
		int maxDist = -1;
		int maxIdx = N+1;
		for (int i=1;i<N+1;i++) {
			if (maxDist<result[i]) {
				maxIdx = i;
				maxDist = result[i];
			}
		}
		
		System.out.println(maxIdx);
	}
	
	static int[] dijkstra(int start) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, 1_000_000_000);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.offer(new Pair(start,0));
		while (!pq.isEmpty()) {
			Pair curNode = pq.poll();
			// curNode�� distance�� ���� ���κ����� �Ÿ��� ������ ����
			// curNode�� �ִܰŸ��� �̹� ���ŵǾ� �ִٸ� ��Ƽ��
			if (distance[curNode.node]<curNode.distance) continue;
			
			// ������ �� �ִٸ�, curNode�� ������ nextNode�鿡 ���Ͽ� curNode�� ���� nextNode�� ���� ��θ� ������ �� �ִ��� �Ǻ�
			// nextNode�� �ִܰŸ��� ���ŵǸ�, �켱���� ť�� �ش� ���� ������ �Ÿ� ������ ��� offer
			for (Pair nextNode:adjList[curNode.node]) {
				if (distance[nextNode.node]>distance[curNode.node]+nextNode.distance) {
					distance[nextNode.node] = distance[curNode.node]+nextNode.distance;
					pq.offer(new Pair(nextNode.node,distance[nextNode.node]));
				}
			}
			
		}
		
		
		return distance;
	}

}
