
public class Edge {
	int dist;
	City u;
	City v;
	
	public Edge (City u, City v, int dist) {
		this.u = u;
		this.v = v;
		this.dist = dist;
	}
	
	public int getDist() {
		return dist;
	}
	
	

}
