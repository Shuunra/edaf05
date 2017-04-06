
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;


public class SpanningMain {
	
	public static void main(String[] args) {
		
		HashMap<String, City> cities = new HashMap<String, City>();
		ArrayList<String> cityName = new ArrayList<String>();
		
		//ArrayList<City> cities = new ArrayList<City>();
		//ArrayList<Edge> edges = new ArrayList<Edge>();
		
		//String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\spanning-usa\\data\\USA-highway-miles.txt";
		//String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-alpha.txt";
		String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-alpha.txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			int i = 0;
			while (line.charAt(line.length()-1) != ']' ) {
				if (line.charAt(0) == '"' ) {
					line = line.substring(1, line.length() - 1);
				}
				cities.put(line, new City(line));
				cityName.add(line);
				i++;
				line = br.readLine();
			}
			while(br.readLine() != null) {
				String[] parts = line.split("--|\"|\\[|\\]+");//Add a + mby? Delimiters are --, ", [ and ]
				String U = parts[0];						 //Also problem with splitting using blank space and "
				City b = cities.get(U);//Gotta fix getting ahold of city...
				String V = parts[1].substring(0, parts[1].length()-1);
				City a = cities.get(V);
				String dist = parts[2];
				int dis = Integer.parseInt(dist.substring(1));
				Edge E = new Edge(a,b,dis);
				a.addEdge(E);
				b.addEdge(E);
				

			}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("File not found exception");
		}

		catch (IOException e) {
			System.out.print("I/O exception");

		}
		
		Prims(cities,cityName);
	}
	
		public static void Prims (HashMap<String, City> hm, ArrayList<String> cities) {
			PriorityQueue<City> pq = new PriorityQueue<City>();
			ArrayList<City> spanningTree = new ArrayList<City>();
			
			for (String c : cities) {
				pq.offer(hm.get(c));
			}
			City a = pq.poll();
			a.setDist(0);
			pq.add(a);
			
			while (!pq.isEmpty()) {
				City u = pq.poll();
				spanningTree.add(u);
				for (int i = 0; i < u.getEdges().size(); i++) {
					if ((!spanningTree.contains(u.getEdges().get(i).cityU()) && spanningTree.contains(u.getEdges().get(i).cityV())) ||
							(spanningTree.contains(u.getEdges().get(i).cityU()) && !spanningTree.contains(u.getEdges().get(i).cityV()))) {
						City v;
						if (u == u.getEdges().get(i).cityU()) {
							v = u.getEdges().get(i).cityV();
						} else {
							v = u.getEdges().get(i).cityU();
						}
						if ((u.getEdges().get(i).getDist() < v.getDist())) {
							v.setDist(u.getEdges().get(i).getDist());
						}
					}
					
				}
							
			}
			
			int totalDist = 0;
			for(int i=0; i < spanningTree.size(); i++) {
				totalDist = totalDist + spanningTree.get(i).getDist();
			}
			System.out.println(totalDist);
			
			
		}

	}

	 
	


