import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SovietMain {

	public static void main(String[] args) {
		
		String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\flow\\data\\rail.txt";
		ArrayList<String> railStation = new ArrayList<String>();
		ArrayList<String> railroads = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine().trim();
			int n = Integer.parseInt(line);
			for(int i = 0; i < n; i++) {
				line = br.readLine().trim();
				railStation.add(line);
			}
			line = br.readLine().trim();
			int m = Integer.parseInt(line);
			for(int i = 0; i < m; i++) {
				line = br.readLine().trim();
				String[] parts = line.split("\\s+");
				//Manipulate railStations a bit
				railroads.add(parts[parts.length-1]);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String BFS(ArrayList<String> graph, String source, String sink) {
		ArrayList<String> searchRoads = new ArrayList<String>();
		ArrayList<String> finalRoad = new ArrayList<String>();
		searchRoads.add(source);
		String endRoad = "asdf"; //null
		for(int i = 0; i < source.length(); i++) {
			searchRoads.add(source.substring(i, i));
		}
		int a = 1;
		while(a < searchRoads.size()) {
			boolean foundRoad = false;
			String currentStation = searchRoads.get(a);
			for(int i = 0; i < currentStation.length(); i++) {
				int b = 0;
				if(!searchRoads.contains(currentStation.substring(b, b))) {
					searchRoads.add(currentStation.substring(b, b));
					//b.addParent;
					if(b == sink.length()) {
						foundRoad = true;
						b = endRoad.length();
						break;
					}
				}
			}
			a++;
			if(foundRoad == true) {
				break;
			}
		}
		String reachedEnd = null;
		while(!reachedEnd.equals(source)) {
			finalRoad.add("endRoad");
			reachedEnd = "endRoadParent";
		}
		return null;
	}

	
	public ArrayList<String> findMinCut(ArrayList<String> railway) {
		//Create G_f
		//Reach furthermost nodes
		//Add these to ArrayList<String> foundCut
		//return foundCut
		return null;
	}
	
		
		//HashMap<Integer, Station> networkMap = new HashMap<Integer, Station>();
		HashMap<Edge, Integer> forwardFlow = new HashMap<Edge, Integer>();
		HashMap<Edge, Integer> reverseFlow = new HashMap<Edge, Integer>();
		// Initially make the "Integer (flow) = 0" for all edges that are put in the flowMap
		// Put in edge and reverseEdge in flowMap or have two separate maps
		
		public int Augment (ArrayList<Edge> path) {
			int pathFlow = Integer.MAX_VALUE;
			for (Edge e : path) {
				int currCapacity = e.getCapacity() - forwardFlow.get(e);
				if (currCapacity < pathFlow) {
					pathFlow = e.getCapacity();
				}
			}
		for (Edge e: path) {
			if (forwardFlow.containsKey(e)) {
				forwardFlow.put(e, forwardFlow.get(e) + pathFlow);
			} else {
				reverseFlow.put(e, reverseFlow.get(e) - pathFlow);
				
			}
			
		}
		return pathFlow;
		
	}
		
		public int MaxFlow () {
//		Initially f(e) = 0 for all e in G -- Fix it in an earlier stage
//		While there is an s-t path in the residual graph Gf
//			Let P be a simple s-t path in Gf
			ArrayList<Edge> path = new ArrayList<Edge>();
			int totalFlow = 0;
			while (path != null) {
				totalFlow = totalFlow + Augment(path);
//				Update the residual graph Gf to be Gf'
			}
			return totalFlow;
		}
	
	
}
