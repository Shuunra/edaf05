import java.util.ArrayList;
import java.util.HashMap;

public class FlowMain {
	
	//public static void main(String[] args) {
		
		HashMap<Integer, Station> networkMap = new HashMap<Integer, Station>();
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
