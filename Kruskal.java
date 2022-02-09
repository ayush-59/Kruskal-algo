package Kruskal;
import java.util.Scanner;

public class Kruskal {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int edges = sc.nextInt();
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		UnionFind uf = new UnionFind(size);
		
		for(int i = 0; i < edges; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			pq.add(new Edge(a, b, weight));
		}
		sc.close();
		
		int count = 0, sum = 0;
		while(count < size-1) {
			Edge edge = pq.get();
			
			if(uf.isConnected(edge.a, edge.b)) 
				continue;
			
			System.out.println(edge);
			uf.union(edge.a,  edge.b);
			count++;
			sum+=edge.weight;
		}
	 System.out.println(sum);
		
	}
}
