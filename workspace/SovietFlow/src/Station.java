import java.util.ArrayList;

public class Station {
	private String name;
	private ArrayList<Edge> connectedRoads = new ArrayList<Edge>();
	
	public Station (String name, ArrayList<Edge> roads) {
		this.name = name;
		connectedRoads = roads;
	}

}
