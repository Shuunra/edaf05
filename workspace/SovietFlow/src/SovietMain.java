import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SovietMain {

	public static void main(String[] args) {

		String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\flow\\data\\rail.txt";
		ArrayList<Station> railStation = new ArrayList<Station>();
		ArrayList<Edge> railroads = new ArrayList<Edge>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine().trim();
			int n = Integer.parseInt(line);
			for (int i = 0; i < n; i++) {
				line = br.readLine().trim();
				railStation.add(new Station(line));
			}
			line = br.readLine().trim();
			int m = Integer.parseInt(line);
			for (int i = 0; i < m; i++) {
				line = br.readLine().trim();
				String[] parts = line.split("\\s+");
				int sink = Integer.parseInt(parts[0]);
				int source = Integer.parseInt(parts[1]);
				int capacity = Integer.parseInt(parts[2]);
				Edge e = new Edge(sink, source, capacity);
				railroads.add(e);
				Station a = railStation.get(e.getSink());
				Station b = railStation.get(e.getSource());
				a.addEdge(e);
				b.addEdge(e);
				a.addStation(b);
				b.addStation(a);

			}
			br.close();

			// Solve problem here
			// Run MaxFlow
			// Run findMinCut

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Edge> BFS(ArrayList<Edge> graph, Station source, Station sink) {
		ArrayList<Station> searchRoads = new ArrayList<Station>();
		ArrayList<Station> finalRoad = new ArrayList<Station>();
		searchRoads.add(source);
		Station endRoad = null;
		searchRoads.addAll(source.getStations());
		int a = 0; // Counter which check that we stop iterating when all nodes
					// has been examined
		while (a < searchRoads.size()) {
			boolean foundRoad = false;
			Station currentStation = searchRoads.get(a);
			for (int i = 0; i < currentStation.getStations().size(); i++) {
				Station b = currentStation.getStations().get(i);
				if (!searchRoads.contains(b)) {
					searchRoads.add(b);
					b.addParent(currentStation);
					if (b.getName().equals("DESTINATIONS")) {
						foundRoad = true;
						endRoad = b;
						break;
					}
				}
			}
			a++;
			if (foundRoad == true) {
				break;
			}
		}

		if (endRoad == null) {
			return null;
		}

		Station reachedEnd = null;
		while (!reachedEnd.equals(source)) {
			finalRoad.add(endRoad);
			endRoad = endRoad.getParent();
			reachedEnd = endRoad;
		}
		finalRoad.add(endRoad);
		Collections.reverse(finalRoad);

		ArrayList<Edge> path = new ArrayList<Edge>();
		for (int i = 0; i < finalRoad.size() - 1; i++) {
			Station A = finalRoad.get(i);
			Station B = finalRoad.get(i + 1);
			for (int j = 0; j < A.getEdges().size(); j++) {
				if (A.getEdges().get(j).equals(B)) {
					path.add(A.getEdges().get(j));
				}
			}
		}

		return path;
	}

	public ArrayList<Edge> findMinCut(ArrayList<Station> railway) {
		// Input G

		ArrayList<Edge> GfTree = new ArrayList<Edge>(); // All reachable edges
		ArrayList<Station> GfNode = new ArrayList<Station>(); // All reachable
																// nodes/stations
		ArrayList<Station> MinCutStation = new ArrayList<Station>(); // Outermost
																		// stations
		ArrayList<Edge> MinCutEdge = new ArrayList<Edge>(); // Edges on
															// bottleneck of
															// graph

		// Reach furthermost nodes
		// Start with source

		Station source = railway.get(0);
		GfNode.add(source);
		int counter = 0; // Supposed to prevent ArrayIndexOutOfBoundsException,
							// but still checking all nodes we have to
		for (int i = 0; i < source.getEdges().size(); i++) {
			Edge e = source.getEdges().get(i);
			if (e.getFFlow() > 0) { // Add to reachable if forwardFlow > 0
				GfTree.add(e);
				source.setMinCut(true); // Has contributed to the tree
				if (GfNode.contains(railway.get(e.getSink()))) {
					GfNode.add(railway.get(e.getSource()));
				} else {
					GfNode.add(railway.get(e.getSink()));
				}
			}
		}
		if (GfNode.size() == 1) { // MinCut is the source
			return source.getEdges();
		}
		counter++;

		while (counter < GfNode.size()) { // Same as above, for all other nodes
			Station node = GfNode.get(counter);
			for (int i = 0; i < node.getEdges().size(); i++) {
				Edge e = node.getEdges().get(i);
				if (!GfTree.contains(e)) {
					if (e.getFFlow() > 0) {
						GfTree.add(e);
						node.setMinCut(true);
						if (GfNode.contains(railway.get(e.getSink()))) {
							GfNode.add(railway.get(e.getSource()));
						} else {
							GfNode.add(railway.get(e.getSink()));
						}
					}
				}
				// Add outermost nodes to MinCutEdge
				if (node.getMinCut() == false) {
					MinCutStation.add(node);
					for (int j = 0; j < node.getEdges().size(); j++) {
						if (!GfTree.contains(node.getEdges().get(j))) {
							MinCutEdge.add(node.getEdges().get(j));
						}
					}
				}
			}
			counter++;
		}

		return MinCutEdge;
	}

	ArrayList<Edge> network = new ArrayList<Edge>();
	ArrayList<Edge> resNetwork = new ArrayList<Edge>();
	// HashMap<Integer, Station> networkMap = new HashMap<Integer, Station>();
	// HashMap<Edge, Integer> forwardFlow = new HashMap<Edge, Integer>();
	// HashMap<Edge, Integer> reverseFlow = new HashMap<Edge, Integer>();
	// Initially make the "Integer (flow) = 0" for all edges that are put in the
	// flowMap
	// Put in edge and reverseEdge in flowMap or have two separate maps

	public int Augment(ArrayList<Edge> path) {
		int pathFlow = Integer.MAX_VALUE;
		for (Edge e : path) {
			int currCapacity = e.getCapacity() - e.getFFlow();
			if (currCapacity < pathFlow) {
				pathFlow = e.getCapacity();
			}
		}
		for (Edge e : path) {
			if (e.getFFlow() > 0) {
				forwardFlow.put(e, forwardFlow.get(e) + pathFlow);
			} else {
				reverseFlow.put(e, reverseFlow.get(e) - pathFlow);

			}

		}
		return pathFlow;

	}

	public int MaxFlow() {
		// Initially f(e) = 0 for all e in G -- Fix it in an earlier stage
		// While there is an s-t path in the residual graph Gf
		// Let P be a simple s-t path in Gf
		ArrayList<Edge> path = new ArrayList<Edge>();
		int totalFlow = 0;
		while (path != null) {
			totalFlow = totalFlow + Augment(path);
			// Update the residual graph Gf to be Gf'
		}
		return totalFlow;
	}

}
