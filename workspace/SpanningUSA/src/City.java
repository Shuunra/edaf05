import java.util.ArrayList;
import java.util.Comparator;

public class City implements Comparable<Edge>{
	String name;
	int dist;
	ArrayList<Edge> allEdges = new ArrayList<Edge>();
	
	public City (String name, int dist, ArrayList<Edge> allEdges) {
		this.name = name;
		this.dist = dist;
		this.allEdges = allEdges;
	}
	
	public void setDist(int shortestDist) {
		dist = shortestDist;
	}

	@Override
	public int compareTo(Edge e) {
		if (dist > e.dist) {
			dist = e.dist;
		}
		return dist;
	}
	
	public ArrayList<Edge> getEdges () {
		return allEdges;
	}
	
	public int getDist() {
		return dist;
	}
	
	
	
	
	
	

}
