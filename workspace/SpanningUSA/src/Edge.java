
public class Edge implements Comparable<Edge> {
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
	
	public City cityU() {
		return u;
	}
	
	public City cityV() {
		return v;
	}
	
	@Override
	public boolean equals(Object o) {
		Edge e = (Edge) o;
		return dist - e.getDist() == 0;
	}

	@Override
	public int compareTo(Edge e) {
		return dist - e.getDist();
	}

}
