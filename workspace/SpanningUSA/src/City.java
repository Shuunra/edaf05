import java.util.ArrayList;

public class City{
	String name;
	int dist = Integer.MAX_VALUE;
	ArrayList<Edge> allEdges = new ArrayList<Edge>();
	
	public City (String name) {
		this.name = name;
	}
	
	public City (String name, int dist, ArrayList<Edge> allEdges) {
		this.name = name;
		this.dist = dist;
		this.allEdges = allEdges;
	}
	
	public void setDist(int shortestDist) {
		dist = shortestDist;
	}
	
//	@Override
//	public boolean equals(Object o) {
//		City c = (City) o;
//		return dist - c.getDist() == 0;
//	}
//
//	@Override
//	public int compareTo(City c) {
//		return dist - c.getDist();
//	}
	
	public ArrayList<Edge> getEdges () {
		return allEdges;
	}
	
	public int getDist() {
		return dist;
	}
	
	public void addEdge(Edge e) {
		allEdges.add(e);
	}
	
	
	
	
	
	

}
