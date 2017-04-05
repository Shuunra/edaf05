
import java.util.ArrayList;
import java.util.PriorityQueue;


public class SpanningMain {
	
	//public static void main(String[] args) {
		
		public ArrayList<Edge> Prim (ArrayList<City> cities, ArrayList<Edge> edges) {
			PriorityQueue<City> pq = new PriorityQueue<City>();
			ArrayList<City> spanningTree = new ArrayList<City>();
			//spanningTree.add(cities.get(0));
			
			int inf = Integer.MAX_VALUE;
			for (City c : cities) {
				c.setDist(inf);
				pq.add(c);
			}
			
			while (!pq.isEmpty()) {
				City u = pq.poll();
				spanningTree.add(u);
				for (int i = 0; i < u.getEdges().size(); i++) {
					if (spanningTree.contains(u.getEdges().get(i).cityU()) && spanningTree.contains(u.getEdges().get(i).cityV())) {
						City v;
						if (u == u.getEdges().get(i).cityU()) {
							v = u.getEdges().get(i).cityV();
						} else {
							v = u.getEdges().get(i).cityU();
						}
						if ((u.getEdges().get(i).getDist() < v.getDist()) && i < (u.getEdges().size() - 1)) {
							v.setDist(u.getEdges().get(i).getDist());
						}
					}
					
				}
							
		}
		
		
		
		

		}

	 
	

}
