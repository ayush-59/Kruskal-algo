package Kruskal;

public class UnionFind {
	private int[] parent;
	private int[] rank;
	private int count;	//count of components
	
	public UnionFind(int size) {
		if(size <= 0)
			throw new IllegalArgumentException("size must be greater than 0");
		count = size;
		parent = new int[size];
		rank = new int[size];
		
		for(int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	private void validate(int x) {
        int n = parent.length;
        if (x < 0 || x >= n) {
            throw new IllegalArgumentException("index " + x + " is not between 0 and " + (n-1));  
        }
    }
	
	public boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}
	
	public int count() {
		return count;
	}
	
	public void union(int x, int y) {
		validate(x);
		validate(y);
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY)
			return;
		
		if(rank[rootX] > rank[rootY])
			parent[rootY] = rootX;
		else if(rank[rootX] < rank[rootY])
			parent[rootX] = rootY;
		else {
			parent[rootY] = rootX;
			rank[rootX]++;
		}
		count--;
	}
	
	public int find(int x) {
		validate(x);
		while(parent[x] != x) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}
		return x;
	}
}
