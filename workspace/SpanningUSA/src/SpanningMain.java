
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class SpanningMain {
	
	public static void main(String[] args) {
		
		ArrayList<City> cities = new ArrayList<City>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		String filename = args[0];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while (line.charAt(line.length()) != ']') {
				cities.add(new City(line));
				br.readLine();
			}
			
			while(br.ready()) {
				String[] parts = line.split("--|\"|\\[|\\]");//Add a + mby? Delimiters are --, ", [ and ]
				String U = parts[0];						 //Also problem with splitting using blank space and "
				City b = cities.get(0);//Gotta fix getting ahold of city...
				String V = parts[1];
				City a = cities.get(1);
				String dist = parts[2];
				Integer dis = Integer.parseInt(dist);
				Edge E = new Edge(a,b,dis);
				a.addEdge(E);
				b.addEdge(E);
				edges.add(E);
				
				br.close();
			}
		}
		catch (FileNotFoundException e) {
			System.out.print("File not found exception");
		}

		catch (IOException e) {
			System.out.print("I/O exception");

		}

	}
	
		public void Prim(ArrayList<City> cities, ArrayList<Edge> edges) {
			PriorityQueue<City> pq = new PriorityQueue<City>();
			ArrayList<City> spanningTree = new ArrayList<City>();
			//spanningTree.add(cities.get(0));
			
			
			
			int inf = Integer.MAX_VALUE;
			for (City c : cities) {
				c.setDist(inf); //Kan fixa detta i City konstruktor senare
				pq.add(c);
				City a = pq.poll();
				a.setDist(0);
				pq.add(a);
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
		int totalDist = 0;
		for(int i=0;i<spanningTree.size();i++) {
			totalDist = totalDist + spanningTree.get(i).getDist();
		}
		System.out.println(totalDist);
		
		

		}

	 
	

}
