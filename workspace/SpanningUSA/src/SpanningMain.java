
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
		HashMap<String, Edge> edges = new HashMap<String, Edge>();
		ArrayList<String> cityName = new ArrayList<String>();
		ArrayList<String> edgeKey = new ArrayList<String>();
		int minDist = Integer.MAX_VALUE;
		Edge minEdgeDist = null;

		//ArrayList<City> cities = new ArrayList<City>();
		//ArrayList<Edge> edges = new ArrayList<Edge>();

		//String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\spanning-usa\\data\\USA-highway-miles.txt";
		//String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-alpha.txt";
		//String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-alpha.txt";
		//String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-beta.txt";
		String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\spanning-usa\\data\\USA-highway-miles.txt";


		try {

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine().trim();
			while (line.charAt(line.length()-1) != ']' ) { //find metod?
				//if (line.charAt(0) == '"' ) {
					//line = line.substring(1, line.length() - 1);
				//}
				cities.put(line, new City(line));
				cityName.add(line);
				line = br.readLine().trim();
			}

			while(line != null) {
				String[] parts = line.split("--|\\[|\\]");//Add a + mby? Delimiters are --, ", [ and ]
				String U = parts[0].trim();						 //Also problem with splitting using blank space and "
				City a = cities.get(U);//Gotta fix getting ahold of city...
				String V = parts[1].trim();
				City b = cities.get(V);
				String dist = parts[2].trim();
				int dis = Integer.parseInt(dist);
				Edge E = new Edge(a,b,dis);
				Edge E2 = new Edge(b,a,dis);
				a.addEdge(E);
				b.addEdge(E2);
				edges.put(line,E);
				edgeKey.add(line);

				if (minDist > dis) {
					minDist = dis;
					minEdgeDist = E;
				}

				line = br.readLine();


			}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("File not found exception");
		}

		catch (IOException e) {
			System.out.print("I/O exception");

		}

		PrimsE(edges ,edgeKey, minEdgeDist);
	}

		public static void Prims (HashMap<String, City> hm, ArrayList<String> cities, Edge minEdge) {
			PriorityQueue<City> pq = new PriorityQueue<City>();
			ArrayList<City> spanningTree = new ArrayList<City>();

			City a = minEdge.cityU();
			a.setDist(0);

			for (String c : cities) {
				City d = hm.get(c);
				pq.offer(d);
			}

			//City a = pq.poll();
			//a.setDist(0);
			//pq.add(a);

			while (!pq.isEmpty()) {
				City u = pq.poll();
				spanningTree.add(u);
				PriorityQueue<City> temp = new PriorityQueue<City>();

				for (int i = 0; i < u.getEdges().size(); i++) {
					Edge e = u.getEdges().get(i);
					City v = e.cityV();
					if (!spanningTree.contains(v)) {
						if (e.getDist() < v.getDist()) {
							v.setDist(e.getDist());
						}
					}

//					if ((!spanningTree.contains(u.getEdges().get(i).cityU()) && spanningTree.contains(u.getEdges().get(i).cityV())) ||
//							(spanningTree.contains(u.getEdges().get(i).cityU()) && !spanningTree.contains(u.getEdges().get(i).cityV()))) {
//						City v;
//						if (u == u.getEdges().get(i).cityU()) {
//							v = u.getEdges().get(i).cityV();
//						} else {
//							v = u.getEdges().get(i).cityU();
//						}
//						if ((u.getEdges().get(i).getDist() < v.getDist())) {
//							v.setDist(u.getEdges().get(i).getDist());
//						}
//					}

				}

				while(!pq.isEmpty()) {
					temp.offer(pq.poll());
				}

				pq = temp;

			}

			int totalDist = 0;
			for(int i=0; i < spanningTree.size(); i++) {
				totalDist = totalDist + spanningTree.get(i).getDist();
			}
			System.out.println(totalDist);


		}
		
		public static void PrimsE (HashMap<String, Edge> hm, ArrayList<String> edger, Edge minEdge) {
			//PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			PriorityQueue<Edge> pq2 = new PriorityQueue<Edge>();
			ArrayList<City> spanningTree = new ArrayList<City>();
			ArrayList<Edge> spanningEdge = new ArrayList<Edge>();
			int totalDist = 0;
			
			Edge ed = minEdge;
			City cit = ed.cityU();
			City ci = ed.cityV();
			spanningTree.add(cit);
			spanningTree.add(ci);
			spanningEdge.add(ed);
			totalDist = ed.getDist();
			for(int i = 0; i < cit.allEdges.size(); i++) {
				if(!spanningEdge.contains(cit.allEdges.get(i))) {
					pq2.add(cit.allEdges.get(i));
				}
			}
			for(int i = 0; i < ci.allEdges.size(); i++) {
				if(!spanningEdge.contains(ci.allEdges.get(i))) {
					pq2.add(ci.allEdges.get(i));
				}
			}
			
			while (!pq2.isEmpty()) {
				Edge u = pq2.poll();
				if(!spanningTree.contains(u.cityV())) {
					City c = u.cityV();
					spanningTree.add(c);
					spanningEdge.add(u);
					totalDist = totalDist + u.getDist();
					for(int i = 0; i < c.allEdges.size(); i++) {
						if(!spanningEdge.contains(c.allEdges.get(i))) {
						pq2.add(c.allEdges.get(i));
						}
					}
				}
				



			}

//			int totalDist = 0;
//			for(int i=0; i < spanningEdge.size(); i++) {
//				totalDist = totalDist + spanningEdge.get(i).getDist();
//			}
			System.out.println(totalDist);


		}

	}
