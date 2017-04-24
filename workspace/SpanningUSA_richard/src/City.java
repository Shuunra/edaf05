import java.util.ArrayList;

public class City implements Comparable<Object>{
	String name;
	int dist;
	ArrayList<Edge> allEdges;
	
	public City (String name) {
		this.name = name;
		this.dist = Integer.MAX_VALUE;
		this.allEdges = new ArrayList<Edge>();
	}
	
	@Override
	public boolean equals(Object o) {
		City c = (City) o;
		return (this.dist - c.dist == 0);
	}

	@Override
	public int compareTo(Object o) {
		City c = (City) o;
		return this.dist - c.dist;
	}
	
	public void addEdge(Edge e) {
		allEdges.add(e);
	}


}
