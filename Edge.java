package Kruskal;

class Edge implements Comparable<Edge>{
	int a;
	int b;
	int weight;
	
	public Edge(int a, int b, int weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
	
	public int compareTo(Edge other) {
		if(this.weight > other.weight)
			return 1;
		if(this.weight < other.weight)
			return -1;
		return 0;
	}
	
	public String toString() {
		return "a = " + a + ", b = " + b + ", weight = " + weight;
	}
}
