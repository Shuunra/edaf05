import java.util.ArrayList;

public class Station {
	private String name;
	private ArrayList<Edge> connectedRoads = new ArrayList<Edge>();
	private ArrayList<Station> connectedStations = new ArrayList<Station>();
	private Station parent;
	private boolean mcc = false; //Min Cut Contribution

	
	public Station (String name, ArrayList<Edge> roads) {
		this.name = name;
		connectedRoads = roads;
	}
	
	public Station (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addEdge(Edge e) {
		connectedRoads.add(e);
	}
	
	public ArrayList<Edge> getEdges() {
		return connectedRoads;
	}
	
	public void addStation(Station s) {
		connectedStations.add(s);
	}
	
	public ArrayList<Station> getStations() {
		return connectedStations;
	}
	
	public void addParent(Station s) {
		parent = s;
	}
	
	public Station getParent() {
		return parent;
	}

	public boolean getMinCut() {
		return mcc;
	}
	
	public void setMinCut(boolean b) {
		mcc = b;
	}

}
